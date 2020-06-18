package com.yu.array;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums.length==0){
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                int flag = 0;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != val){
                        nums[i] = nums[j];
                        nums[j] =  val;
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0){
                    return i;
                }
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {

//        int[] nums = {0,1,2,2,3,0,4,2};
//        int[] nums = {2};
        int[] nums = {3,3};
//        int[] nums = {3,2,2,3};

        int len = removeElement(nums,5);

        System.out.println(len);
    }
}
