package com.jumong.internshiptaskone.controller;


import com.jumong.internshiptaskone.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;

    @GetMapping("/fibonacci")
    public List<Long> getFibonacci(@RequestParam int n) {
        return fibonacciService.generateFibonacci(n);
    }
}

