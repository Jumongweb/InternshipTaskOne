FROM maven:3.8.7 as build
COPY . .
RUN mvn -B clean package -DskipTests

FROM openjdk:17
COPY --from=build target/*.jar InternshipTaskOne.jar
EXPOSE 2020

ENTRYPOINT ["java", "-jar", "-Dserver.port=2020", "InternshipTaskOne.jar"]