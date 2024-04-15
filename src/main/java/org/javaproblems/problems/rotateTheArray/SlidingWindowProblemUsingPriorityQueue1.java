package org.javaproblems.problems.rotateTheArray;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowProblemUsingPriorityQueue1 {
    public static List<Integer> slidingWindowMaximum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0)
            return new ArrayList<>();

        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max heap

        // Populate the initial window
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        result.add(maxHeap.peek());

        // Slide the window and update the result list
        for (int i = k; i < n; i++) {
            maxHeap.remove(nums[i - k]); // Remove the element going out of the window
            maxHeap.offer(nums[i]); // Add the new element into the window
            result.add(maxHeap.isEmpty() ? null : maxHeap.peek()); // Maximum of the current window
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,3,42,23,7,8};;
        int k = 3;

        List<Integer> result = slidingWindowMaximum(nums, k);
        System.out.println("Maximum values in sliding windows: " + result);
    }
}
