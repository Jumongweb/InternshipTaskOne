#!/bin/bash

# Set the service name from docker-compose.yml
SERVICE_NAME="internshiptaskone-app"
CPU_THRESHOLD=90
MEMORY_THRESHOLD=85
COOL_DOWN_PERIOD=300  # 5 minutes

# File to store the last scale time
LAST_SCALE_FILE="/tmp/last_scale_time.txt"
if [[ ! -f $LAST_SCALE_FILE ]]; then
    echo "0" > $LAST_SCALE_FILE
fi
LAST_SCALE_TIME=$(cat $LAST_SCALE_FILE)
CURRENT_TIME=$(date +%s)

# Get average CPU and memory usage
CPU_USAGE=$(docker stats --no-stream --format "{{.CPUPerc}}" internshiptaskone-app-1 | sed 's/%//' | awk '{s+=$1} END {print s/NR}')
MEMORY_USAGE=$(docker stats --no-stream --format "{{.MemPerc}}" internshiptaskone-app-1 | sed 's/%//' | awk '{s+=$1} END {print s/NR}')

scale_container() {
    echo "$(date): Scaling up container..." >> autoscale.log
    docker-compose up --scale $SERVICE_NAME=2 -d
    echo "$CURRENT_TIME" > $LAST_SCALE_FILE
}

scale_down_container() {
    echo "$(date): Scaling down container..." >> autoscale.log
    docker-compose up --scale $SERVICE_NAME=1 -d
    echo "$CURRENT_TIME" > $LAST_SCALE_FILE
}

# Check if within cool-down period
if (( CURRENT_TIME - LAST_SCALE_TIME < COOL_DOWN_PERIOD )); then
    echo "$(date): In cool-down period. No scaling performed." >> autoscale.log
    exit 0
fi

# Perform scaling logic
if (( $(echo "$CPU_USAGE > $CPU_THRESHOLD" | bc -l) )); then
    echo "CPU usage is above threshold ($CPU_USAGE%), scaling container."
    scale_container
elif (( $(echo "$MEMORY_USAGE > $MEMORY_THRESHOLD" | bc -l) )); then
    echo "Memory usage is above threshold ($MEMORY_USAGE%), scaling container."
    scale_container
elif (( $(echo "$CPU_USAGE < 70" | bc -l) )) && (( $(echo "$MEMORY_USAGE < 70" | bc -l) )); then
    echo "Resource usage is low, scaling down."
    scale_down_container
else
    echo "$(date): Resource usage normal (CPU: $CPU_USAGE%, Memory: $MEMORY_USAGE%). No scaling needed." >> autoscale.log
fi