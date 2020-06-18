package com.yu.num;

import java.util.Collections;

public class ClimbingStairs {
    public static int climbStairs(int n) {

        if (n <= 1) {
            return n;
        }
        int fn1 = 1;
        int fn2 = 2;
        while (n > 2) {
            int tmp = fn2;
            fn2 = fn1 + fn2;
            fn1 = tmp;

            n--;
        }


        return fn2;
    }

    public static void main(String[] args) {

        int teps = climbStairs(5);
        System.out.println(teps);
    }
}
