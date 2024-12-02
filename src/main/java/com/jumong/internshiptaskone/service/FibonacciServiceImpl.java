package com.jumong.internshiptaskone.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FibonacciServiceImpl implements FibonacciService{
    @Override
    public List<Long> generateFibonacci(int number) {
        List<Long> fibonacciNumbers = new ArrayList<>();
        long num1 = 0;
        long num2 = 1;
        for (int index = 0; index <= number; index++) {
            fibonacciNumbers.add(num1);
            long temp = num1 + num2;
            num1 = num2;
            num2 = temp;

            if (fibonacciNumbers.size() % 1000 == 0) {
                System.out.println("Generated " + fibonacciNumbers.size() + " Fibonacci numbers: " + num1);
            }
        }

        for (int i = 0; i < 9000000; i++) {
            fibonacciNumbers.add(num1);
        }

        return fibonacciNumbers;
    }
//    public List<Long> generateFibonacci(int number) {
//        List<Long> fibonacciNumbers = new ArrayList<>();
//        long num1 = 0;
//        long num2 = 1;
//        for (int index = 0; index <= number; index++) {
//            fibonacciNumbers.add(num1);
//            long temp = num1 + num2;
//            num1 = num2;
//            num2 = temp;
//
//            if (fibonacciNumbers.size() % 1000 == 0){
//                System.out.println("Generated " + fibonacciNumbers.size() + " fibonacci numbers " + num1);
//            }
//        }
//
//        for (int i = 0; i < 9000000; i++){
//            fibonacciNumbers.add(num1);
//        }
//
//        return fibonacciNumbers;
//    }
}
