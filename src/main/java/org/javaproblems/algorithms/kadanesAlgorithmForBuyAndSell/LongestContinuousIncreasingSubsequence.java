package org.javaproblems.algorithms.kadanesAlgorithmForBuyAndSell;

/**
 * Problem Statement:
 * Given an unsorted array of integers, find the length of the
 * longest continuous increasing subsequence.
 *
 * Example:
 * Input: [1, 3, 5, 4, 7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1, 3, 5].
 */
public class LongestContinuousIncreasingSubsequence {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int maxLength = 1;
        int currentLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 5, 6, 4, 7};
        int lengthOfLCIS = findLengthOfLCIS(input);
        System.out.println("Length of the longest continuous increasing subsequence: " + lengthOfLCIS);
    }
}
