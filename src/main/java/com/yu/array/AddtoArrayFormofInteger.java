package com.yu.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * If A.length > 1, then A[0] != 0
 * <p>
 * <p>
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 */
public class AddtoArrayFormofInteger {

    public static List<Integer> addToArrayForm(int[] A, int K) {

        List<Integer> result = new ArrayList<>();

        boolean carry = false;

        String KStr = String.valueOf(K);
        int i = A.length - 1;
        int j = KStr.length() - 1;

        while (i >= 0 || j >= 0) {

            int a = i >= 0 ? A[i] : 0;
            int b = j >= 0 ? Integer.parseInt(String.valueOf(KStr.charAt(j))) : 0;

            int sum = a + b + (carry ? 1 : 0);
            result.add(sum % 10);
            carry = sum / 10 > 0;


            i--;
            j--;
        }

        if (carry) {
            result.add(1);
        }
        Collections.reverse(result);
        return result;
    }

    public static List<Integer> addToArrayForm2(int[] A, int K) {


        List<Integer> result = new ArrayList<>();
        int cur = K;
        for (int i = A.length - 1; i >= 0; i--) {

            cur += A[i];

            result.add(cur % 10);
            cur = cur / 10;

        }
        if (cur > 0) {
            char[] chars = String.valueOf(cur).toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                result.add(Integer.parseInt(String.valueOf(chars[i])));
            }
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] A = {0};
        int K = 1000;

        List<Integer> result = addToArrayForm2(A, K);
        System.out.println(result);
    }
}
