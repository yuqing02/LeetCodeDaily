package com.yu.array;

import java.util.*;

public class RemoveDuplicatesOfArray {

    public static int removeDuplicates(int[] nums) {
        int len = 0;
        if (nums.length == 0){
            return len;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[len] != nums[i]){
                ++len;
                nums[len] = nums[i];
            }
        }
        return ++len;
    }

    public static void main(String[] args) {

        int[] param = {0,0,1, 1, 2};
        int length = removeDuplicates(param);
        System.out.println(length);
    }
}
