package com.yu.num;

public class ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {

        int result = (int) Math.sqrt(num);
        return result * result == num;
    }

    public static boolean isPerfectSquare2(int num) {

        if (num <= 1) {
            return true;
        }
        int low = 1, high = num;

        while (low < high-1) {

            int mid = low + (high - low) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                high = mid;
            } else {
                low = mid;
            }

        }

        return false;
    }

    public static void main(String[] args) {
//        boolean result = isPerfectSquare2(808201);
        boolean result = isPerfectSquare(808201);

        System.out.println(result);
    }
}
