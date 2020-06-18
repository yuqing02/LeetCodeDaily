package com.yu.array;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {


//        StringBuilder stringBuilder = new StringBuilder();
//
//        for (int digit : digits) {
//            stringBuilder.append(digit);
//
//        }
//        int num = Integer.parseInt(stringBuilder.toString());
//
//
//        if (Integer.toString(num + 1).length() > Integer.toString(num).length()) {
//            digits = new int[digits.length + 1];
//        }
//        num++;
//
//        int i = 0;
//        while (num > 0) {
//            digits[digits.length - 1 - i] = num % 10;
//            num = num / 10;
//            i++;
//        }
//        if (digits[digits.length - 1] >= 0) {
////            if (digits[digits.length - 1] % 10 == 9){
////                digits = Arrays.copyOf(digits, digits.length + 1);
////                digits[digits.length - 1] = 1
////            }
//            if (digits[0] == 9) {
//                digits = new int[digits.length + 1];
//                digits = Arrays.copyOf(digits, digits.length);
//                digits[digits.length - 2] = 1;
//                digits[digits.length - 1] = 0;
//            } else {
//                digits[digits.length - 1]++;
//            }
//        }

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
        }
        if (digits[0] == 0) {
            digits = Arrays.copyOf(digits, digits.length + 1);
            digits[0] = 1;
            return digits;
        }
        return digits;
    }

        public static void main (String[]args){
//        int[] digits = {5, 9, 9};
            int[] digits = {9};
            int[] gdd = plusOne(digits);
            System.out.println(gdd);
        }
    }
