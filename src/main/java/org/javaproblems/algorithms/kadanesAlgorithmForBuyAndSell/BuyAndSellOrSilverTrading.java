package org.javaproblems.algorithms.kadanesAlgorithmForBuyAndSell;

import java.util.Scanner;

public class BuyAndSellOrSilverTrading {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of days: ");
        int numDays = scanner.nextInt();

        int[] prices = new int[numDays];
        System.out.println("Enter the prices for each day:");
        for (int i = 0; i < numDays; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            prices[i] = scanner.nextInt();
        }

        int maxProfit = maxProfit(prices);
        System.out.println("Maximum profit: " + maxProfit);

        scanner.close();
    }
}
