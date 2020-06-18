package com.yu.num;

import java.util.HashMap;
import java.util.Map;

public class TwoNums {

    public static void main(String[] args) {

    }

    /**
     * The brute force approach is simple. Loop through each element
     * xx and find if there is another value that equals to target - xtarget−x.
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < (nums.length - 1); i++) {
            for (int j = i + 1; j < (nums.length); j++) {
                if (nums[j] == (target - nums[i])) {
//                    if ((nums[j] + nums[i]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * To improve our run time complexity, we need a more efficient way to check if the complement exists in the array.
     * If the complement exists, we need to look up its index.
     * What is the best way to maintain a mapping of each element in the array to its index? A hash table.
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * It turns out we can do it in one-pass. While we iterate and inserting elements into the table, we also look back to check if
     * current element's complement already exists in the table. If it exists, we have found a solution and return immediately.
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
