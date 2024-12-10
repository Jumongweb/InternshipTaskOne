package com.jumong.internshiptaskone.controller;

import com.jumong.internshiptaskone.dtos.request.RegisterRequest;
import com.jumong.internshiptaskone.dtos.response.RegisterResponse;
import com.jumong.internshiptaskone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Jumong! This is a test application for Jumong Cloud";
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse registerResponse = userService.register(registerRequest);
        return ResponseEntity.ok(registerResponse);
    }

    @GetMapping("/fibonacci/{n}")
    public List<Long> getFibonacci(@PathVariable int n) {
        return generateFibonacci(n);
    }

    // Simple Fibonacci generator
    private List<Long> generateFibonacci(int n) {
        List<Long> fibonacciSeries = new ArrayList<>();
        if (n <= 0) return fibonacciSeries;

        long first = 0, second = 1;
        fibonacciSeries.add(first);

        if (n > 1) {
            fibonacciSeries.add(second);
            for (int i = 2; i < n; i++) {
                long next = first + second;
                fibonacciSeries.add(next);
                first = second;
                second = next;
            }
        }
        return fibonacciSeries;
    }


}
