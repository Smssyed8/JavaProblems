package org.javaproblems.algorithms.kadanesAlgorithmForBuyAndSell;

/**
 *
 Certainly! I can provide you with a Java interview problem-solving scenario.
 Here's a classic problem often used in technical interviews:

 Problem Statement:
 You are given an array of integers.
 Write a Java method to find the maximum sum of a contiguous subarray within the array.

 Example:
 Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 Output: 6
 Explanation: The contiguous subarray [4, -1, 2, 1] has the largest sum, which is 6.

 Solution Approach:
 This problem can be solved using the Kadane's algorithm,
 which is a well-known algorithm for finding the maximum subarray sum. Here's how it works:

 Initialize two variables, maxSoFar and maxEndingHere,
 to track the maximum sum found so far and the maximum sum ending at the current position,
 respectively.
 Iterate through the array.
 At each step, update maxEndingHere as
 the maximum of the current element or the sum of the current element and
 the previous maxEndingHere.
 Update maxSoFar as the maximum of maxSoFar and maxEndingHere.
 After iterating through the array, maxSoFar will hold the maximum sum of a contiguous subarray.
 */
public class MaximumSumOfContiguousSubArray {
    public static void main(String[] args){
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(getSumOfContiguouSubArray(arr));
    }

    private static int getSumOfContiguouSubArray(int[] arr) {
        int maxSoFar = arr[0];
        int previousMax = arr[0];

        for(int i = 1; i < arr.length; i++){
            previousMax = Math.max(arr[i], arr[i] + previousMax);
            maxSoFar =  Math.max(maxSoFar, previousMax);

        }
        return maxSoFar;
    }

}
