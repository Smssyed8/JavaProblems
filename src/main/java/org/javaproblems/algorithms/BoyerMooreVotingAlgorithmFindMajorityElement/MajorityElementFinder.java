package org.javaproblems.algorithms.BoyerMooreVotingAlgorithmFindMajorityElement;

/**
 * The Boyer-Moore Voting Algorithm is an efficient algorithm used to find the majority
 * element in an array, if it exists. The majority element is defined as the element
 * that appears more than ⌊ n/2 ⌋ times, where n is the length of the array.
 *
 * The algorithm iterates through the array, maintaining a candidate and a counter.
 * It updates the candidate when the counter becomes zero and increments or decrements
 * the counter based on whether the current element is equal to the candidate.
 *
 * Here's how the Boyer-Moore Voting Algorithm works:
 *
 * Initialize two variables: candidate and count. Set candidate to any element of the array and count to 1.
 * Iterate through the array:
 * If the current element is equal to the candidate, increment count.
 * If the current element is different from the candidate, decrement count.
 * If count becomes zero, update the candidate to the current element and set count to 1.
 * The candidate obtained after the iteration is a potential majority element. However,
 * it's essential to verify whether it occurs more than ⌊ n/2 ⌋ times in the array.
 * Let's implement the Boyer-Moore Voting Algorithm in Java:
 */
public class MajorityElementFinder {
    public static int findMajorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException("Array is empty or null");

        int candidate = nums[0];
        int count = 1;

        // Find the potential majority candidate
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Verify if the candidate is the majority element
        count = 0;
        for (int num : nums) {
            if (num == candidate)
                count++;
        }

        if (count > nums.length / 2)
            return candidate;
        else
            throw new IllegalArgumentException("No majority element found");
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        try {
            int majorityElement = findMajorityElement(nums);
            System.out.println("Majority Element: " + majorityElement);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
/**
 * Pseudocode
 * Here's a pseudocode representation of the Boyer-Moore Voting Algorithm:
 * BoyerMooreVotingAlgorithm(array):
 *     candidate = null
 *     count = 0
 *
 *     for each element in the array:
 *         if count == 0:
 *             candidate = element
 *             count = 1
 *         else if element == candidate:
 *             count += 1
 *         else:
 *             count -= 1
 *
 *     // Verify candidate
 *     count = 0
 *     for each element in the array:
 *         if element == candidate:
 *             count += 1
 *
 *     if count > array.length / 2:
 *         return candidate
 *     else:
 *         return "No majority element"
 */
