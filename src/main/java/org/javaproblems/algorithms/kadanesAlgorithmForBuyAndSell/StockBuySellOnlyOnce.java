package org.javaproblems.algorithms.kadanesAlgorithmForBuyAndSell;

/**
 * Problem Statement:
 * You are given an array representing the prices of a stock on different days.
 * You can buy and sell the stock only once.
 * Write a Java method to find the maximum profit that can be obtained.
 *
 * Example:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6)
 * to obtain maximum profit of 6 - 1 = 5.
 */
public class StockBuySellOnlyOnce {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum profit: " + maxProfit);
    }
}

