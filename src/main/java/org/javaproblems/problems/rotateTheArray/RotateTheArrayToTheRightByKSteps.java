package org.javaproblems.problems.rotateTheArray;

import java.util.Arrays;

/**
 * Problem Statement:
 * Given an array of integers, write a Java method to rotate the array to the right by k steps,
 * where k is non-negative.
 *
 * Example:
 * Input: [1, 2, 3, 4, 5, 6, 7] and k = 3
 * Output: [5, 6, 7, 1, 2, 3, 4]
 *
 * Solution Approach:
 * One approach to solve this problem is to use the reverse technique. Here's how it works:
 *
 * Reverse the entire array.
 * Reverse the first k elements.
 * Reverse the remaining n-k elements.
 *
 * Using reverse the array
 * Reverse full array.
 * Reverse the first 3 elements
 * then remaining
 */

/**
 * The approach of using three reversals might seem a bit roundabout,
 * but it's actually a clever way to achieve the desired rotation efficiently.
 *
 * Let's consider the example array [1, 2, 3, 4, 5, 6, 7] and k = 3 (rotate to the right by 3 steps).
 *
 * Reverse the entire array: [7, 6, 5, 4, 3, 2, 1]
 * Reverse the first k elements: [5, 6, 7, 4, 3, 2, 1]
 * Reverse the remaining n-k elements: [5, 6, 7, 1, 2, 3, 4]
 * By performing these three reversals, we effectively achieve the rotation in place.
 */
public class RotateTheArrayToTheRightByKSteps {
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0)
            return;

        int n = nums.length;
        k %= n; // Handling cases where k is greater than array length

        reverse(nums, 0, n - 1); // Reverse the entire array
        reverse(nums, 0, k - 1); // Reverse the first k elements
        reverse(nums, k, n - 1); // Reverse the remaining n-k elements
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Original Array: " + Arrays.toString(nums));
        rotate(nums, k);
        System.out.println("Rotated Array: " + Arrays.toString(nums));
    }
}
/**
 * Data Processing: In scenarios where data is processed in chunks or batches, rotating arrays can be useful for managing data flows efficiently.
 * System Design: In system design interviews, you may encounter scenarios where efficient array manipulation is required, such as in designing caching mechanisms or optimizing data storage systems.
 * Algorithm Design: Understanding how to manipulate arrays efficiently is fundamental to many algorithms and data structures. Rotating arrays can be a component of more complex algorithms.
 */
