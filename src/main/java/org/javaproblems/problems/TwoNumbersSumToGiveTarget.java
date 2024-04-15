package org.javaproblems.problems;

/**
 * Problem Statement:
 * You are given an array of integers. Write a Java method to
 * return the indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]
 * Explanation: nums[0] + nums[1] = 2 + 7 = 9.
 *
 * Solution Approach:
 * One approach to solving this problem is by using a HashMap to store the difference between
 * the target and each element as we iterate through the array. If we encounter a number whose
 * complement is already in the HashMap,
 * it means we have found the pair that sums up to the target.
 */
import java.util.HashMap;

public class TwoNumbersSumToGiveTarget {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return new int[0];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] indices = twoSum(nums, target);

        if (indices.length == 2) {
            System.out.println("Indices of the two numbers: [" + indices[0] + ", " + indices[1] + "]");
        } else {
            System.out.println("No solution found.");
        }
    }
}
