package org.javaproblems.algorithms.kadanesAlgorithmForBuyAndSell;

/**
 * 1. Maximum Sum Circular Subarray:
 * To solve this problem, we apply Kadane's algorithm twice:
 *
 * First, we find the maximum sum subarray within the array using Kadane's algorithm.
 * Then, we find the maximum sum subarray when wrapping around from the
 * end of the array to the beginning by taking the total
 * sum of the array and subtracting the minimum sum subarray within the array.
 * Problem Statement:
 * Given a circular array (the next element of the last element is the first element),
 * find the maximum possible sum of a non-empty subarray.
 *
 * Example:
 * Input: [5, -3, 5]
 * Output: 10
 * Explanation: The maximum sum circular subarray is [5, -3, 5], which sums up to 10.
 *
 * second example
 * Example:
 * Input: [1, -2, 3, -2]
 * Output: 3
 * Explanation: The subarray [3] has the maximum sum.
 */
public class MaximumSumCircularSubarray {
    public static int maxSubarraySumCircular(int[] A) {
        int maxSum = kadane(A);
        int totalSum = 0;
        for (int i = 0; i < A.length; i++) {
            totalSum += A[i];
            A[i] = -A[i];   //negate all values.
        }
        int circularMax = totalSum + kadane(A);
        return circularMax > maxSum && circularMax != 0 ? circularMax : maxSum;
    }

    private static int kadane(int[] A) {
        int maxSum = A[0], curSum = A[0];
        for (int i = 1; i < A.length; i++) {
            curSum = Math.max(A[i], curSum + A[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 1, 3, -2, 5};
        int maxSum = maxSubarraySumCircular(nums);
        System.out.println("Maximum sum of circular subarray: " + maxSum);
    }


    /**
     * Applying Kadane's algorithm to the given array,
     * we find that the maximum sum of a non-circular subarray is 7,
     * which corresponds to the subarray [1, 3, -2, 5].
     * Total sum of the array is 6.
     * The minimum sum of a subarray, when the entire array is negated, is -2.
     * The circular sum is 6 - (-2) = 8.
     * Since the circular sum 8 is greater than the maximum sum of a non-circular subarray 7,
     * the output will be 8.
     */
}

