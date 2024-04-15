package org.javaproblems.algorithms.greedyAlgorithmCoinChangeDenomination;

import java.util.Arrays;
import java.util.Collections;

/**
 * Greedy algorithms make locally optimal choices at each step with the hope of finding
 * a global optimum solution. They are often used for optimization problems where finding
 * an exact solution is impractical. A classic example is the coin change problem,
 * where the goal is to find the minimum number of coins needed to make a given amount of change.
 *
 * Example: Coin Change Problem
 */
public class GreedyCoinChangeProblem {
    public static int minCoins(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }
        return count;
    }
    public static int minCoins2(int[] coins, int amount){
        Integer[] coinObjects = new Integer[coins.length];
        for(int i = 0; i < coins.length; i++){
            coinObjects[i] = coins[i];
        }
        int xCount = 0;
        Arrays.sort(coinObjects, Collections.reverseOrder());

        for(Integer denomination: coinObjects){
            int count = (int) (amount / denomination); // 93 / 100 = 0.93 then 93/ 50 = 1
            if (count > 0) {
                //changeDenominations.put(denomination, count);
                amount = amount - (count * denomination);  //93 - (1 * 50)
                xCount += count; // 1
            }
        }
        return xCount;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int amount = 93;
        System.out.println("Minimum number of coins required: " + minCoins2(coins, amount));
    }
}
