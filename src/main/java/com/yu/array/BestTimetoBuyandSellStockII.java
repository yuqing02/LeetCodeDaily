package com.yu.array;

public class BestTimetoBuyandSellStockII {
    public static int maxProfit(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }
        int maxBenifit = 0;
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] - prices[i - 1] > 0) {

                maxBenifit = maxBenifit + (prices[i] - prices[i - 1]);
            }
        }

        return maxBenifit;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        int max = maxProfit(prices);
        System.out.println(max);
    }
}
