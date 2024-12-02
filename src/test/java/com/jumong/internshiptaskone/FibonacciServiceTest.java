package com.jumong.internshiptaskone;

import com.jumong.internshiptaskone.service.FibonacciService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FibonacciServiceTest {

    @Autowired
    private FibonacciService fibonacciService;

//    @Test
//    void testGenerateFibonacciSmallNumber() {
//        List<Long> result = fibonacciService.generateFibonacci(10);
//        List<Long> expected = List.of(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L);
//        assertEquals(expected, result);
//    }
}
