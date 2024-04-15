package org.javaproblems.algorithms.greedyAlgorithmCoinChangeDenomination;
/**
 *
 * Problem Statement:
 * You are working at a supermarket cash counter. After a customer's purchase,
 * you need to return the correct amount of change using the lowest possible
 * denominations of paper notes and coins. Write a Java method to calculate the minimum number
 * of paper notes and coins required to make up the change amount.
 *
 * Example:
 * Suppose a customer's bill is $78.87 and they pay $100.
 * After deducting the bill amount, the change is $21.13. You need to return this change
 * using the lowest possible denominations of paper notes and coins.
 *
 * Solution Approach:
 * To solve this problem, we can start with the highest denomination and progressively
 * move to lower denominations. We keep subtracting the highest denomination that fits
 * within the remaining change until we exhaust the change. We repeat this process for
 * each denomination until the change becomes zero.
 *
 * Yes, there is a well-known algorithm for solving the problem of minimum denominations
 * called the Greedy Algorithm. Here's how it works:
 *
 * Start with the highest denomination available.
 * Keep subtracting the highest possible denomination from the remaining change until
 * the change becomes zero or negative.
 * Move to the next lower denomination and repeat the process until all denominations are considered.
 * The Greedy Algorithm is effective because it always selects the highest denomination
 * that can be used without exceeding the remaining change, thus minimizing the total number
 * of denominations required.
 *
 * Let's implement the Greedy Algorithm for the change-making problem in Java:
 */

import java.util.HashMap;
import java.util.Map;

public class LowestDenominationProblemAtBillingCounter {
    public static Map<Double, Integer> calculateChange(double billAmount, double paidAmount) {
        double change = paidAmount - billAmount;
        double[] denominations = {100, 50, 20, 10, 5, 1, 0.25, 0.10, 0.05, 0.01}; // in dollars

        Map<Double, Integer> changeDenominations = new HashMap<>();

        for (double denomination : denominations) {
            System.out.println("change and :" +change+ " denomination " +denomination);
            int count = (int) (change / denomination);
            System.out.println("count and :" +count+ " calculation " +(change / denomination));
            if (count > 0) {
                changeDenominations.put(denomination, count);

                change -= count * denomination;
                System.out.println("change and " +change+ "  count * denomination: " +(count * denomination));
            }
        }

        return changeDenominations;
    }

    public static void main(String[] args) {
        double billAmount = 78.87;
        double paidAmount = 100.0;

        Map<Double, Integer> change = calculateChange(billAmount, paidAmount);
        System.out.println("Change denominations:");
        for (Map.Entry<Double, Integer> entry : change.entrySet()) {
            System.out.println("$" + entry.getKey() + ": " + entry.getValue());
        }
    }
}
