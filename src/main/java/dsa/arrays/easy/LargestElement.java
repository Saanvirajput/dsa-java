/**
 * 📝 Problem Name: Largest Element in an Array
 * 🌐 Platform: LeetCode / DSA Practice
 * ⚡ Approach: Linear traversal - Keep track of the maximum element found so far.
 * ⏱ Time Complexity: O(N)
 * 📦 Space Complexity: O(1)
 */

package dsa.arrays.easy;

import java.util.*;

public class LargestElement {
    /**
     * Finds the largest element in the given array.
     * @param nums The input array of integers.
     * @return The largest value in the array.
     */
    public int largestElement(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestElement sol = new LargestElement();

        // Example 1
        int[] nums1 = {3, 3, 6, 1};
        System.out.println("Input: [3, 3, 6, 1]");
        System.out.println("Output: " + sol.largestElement(nums1)); // Expected: 6

        // Example 2
        int[] nums2 = {3, 3, 0, 99, -40};
        System.out.println("\nInput: [3, 3, 0, 99, -40]");
        System.out.println("Output: " + sol.largestElement(nums2)); // Expected: 99

        // Example 3
        int[] nums3 = {-4, -3, 0, 1, -8};
        System.out.println("\nInput: [-4, -3, 0, 1, -8]");
        System.out.println("Output: " + sol.largestElement(nums3)); // Expected: 1
    }
}
