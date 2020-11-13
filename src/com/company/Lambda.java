package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lambda {

    private static List<Integer> primeNumbersTill(int n) {
        return IntStream.rangeClosed(2, n)
                .filter(Lambda::isPrime).boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .filter(n -> (n & 0X1) != 0)
                .allMatch(n -> number % n != 0);
    }

    private static int countOfZero(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') count++;
        }
        return count;
    }

    public static int maxZeroBinary(int n) {
        List<Integer> primeNumbers = primeNumbersTill(n);

        return primeNumbers.stream().reduce(2, (x, y) -> {
            String a = Integer.toBinaryString(x);
            String b = Integer.toBinaryString(y);
            return countOfZero(a) > countOfZero(b) ? x : y;
        });
    }

}
