package com.yu.array;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]< target){
                continue;
            }else if (nums[i] >= target){
                return i;
            }
        }

        return nums.length;
    }

    public static void main(String[] args) {


    }
}
