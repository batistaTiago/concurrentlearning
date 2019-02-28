package com.company;

public class PrimeChecker {
    public static boolean isPrime(int n) {
        boolean flag = false;
        for (int i = 2; i <= n / 2; ++i) {
            // condition for nonprime number
            if (n % i == 0) {
                flag = true;
                break;
            }
        }
        return !flag;
    }
}
