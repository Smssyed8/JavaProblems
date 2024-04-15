package org.javaproblems.problems.rotateTheArray;
import java.util.Arrays;
public class RotateArrayUsingAnotherArrayWithSystemArrayCopy {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // Handling cases where k is greater than array length

        // Create a new array to store the rotated elements
        int[] rotatedArray = new int[n];

        // Copy the last k elements to the beginning of the rotated array
        System.arraycopy(nums, n - k, rotatedArray, 0, k);

        // Copy the remaining elements to the end of the rotated array
        System.arraycopy(nums, 0, rotatedArray, k, n - k);

        // Copy the rotated array back to the original array
        System.arraycopy(rotatedArray, 0, nums, 0, n);

        /**
         * can also do,
         * int n = nums.length;
         *         k %= n; // Handling cases where k is greater than array length
         *
         *         int[] rotatedArray = new int[n];
         *         for (int i = 0; i < n; i++) {
         *             int newIndex = (i + k) % n;
         *             rotatedArray[newIndex] = nums[i];
         *         }
         *
         *         // Copy rotatedArray back to nums
         *         System.arraycopy(rotatedArray, 0, nums, 0, n);
         */
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
 * Let's analyze the time complexity of the simplified array rotation algorithm:
 *
 * 1. **System.arraycopy()**:
 *    - The `System.arraycopy()` method is used twice in the algorithm.
 *    - Both operations copy a portion of the array, which takes linear time proportional to the size of the portion being copied.
 *    - Therefore, each `System.arraycopy()` operation has a time complexity of O(n), where n is the number of elements being copied.
 *
 * 2. **Overall Time Complexity**:
 *    - Since we perform two `System.arraycopy()` operations in sequence, the overall time complexity is determined by the sum of their complexities.
 *    - Therefore, the overall time complexity of the algorithm is O(n), where n is the number of elements in the array.
 *
 * In summary, the simplified array rotation algorithm has a time complexity of O(n), where n is the number of elements in the array. This means that the time taken to rotate the array is linearly proportional to the size of the array.
 */