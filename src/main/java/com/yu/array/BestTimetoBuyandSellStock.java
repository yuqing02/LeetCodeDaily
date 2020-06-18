package com.yu.array;

public class BestTimetoBuyandSellStock {

    public static int maxProfit(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }
        int low = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {

            low = Math.min(low, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - low);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = {7,6,4,3,1};
        int ss = maxProfit(nums);
        System.out.println(ss);
    }

}
