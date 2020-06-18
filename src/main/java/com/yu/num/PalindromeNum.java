package com.yu.num;

import javax.sound.midi.SoundbankResource;

public class PalindromeNum {

    public static boolean isPalindrome(int x) {
        boolean flag = false;
        int originX = x;
        int rev = 0;
        if (x >= 0) {
            while (x != 0) {
                int pop = x % 10;

                rev = rev * 10 + pop;

                x /= 10;
            }
            if (rev == originX) {
                flag = true;
            }

        }
        return flag;
    }

    public static void main(String[] args) {
       boolean xx = isPalindrome(-121);
        System.out.println(xx);    }
}
