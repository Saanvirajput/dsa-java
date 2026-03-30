/**
 * 📝 Problem Name: Second Largest Element in an Array
 * 🌐 Platform: LeetCode / DSA Practice
 * ⚡ Approach: Single traversal - Maintain 'largest' and 'secondLargest' variables.
 * ⏱ Time Complexity: O(N)
 * 📦 Space Complexity: O(1)
 */

package dsa.arrays.easy;

import java.util.*;

public class SecondLargestElement {
    /**
     * Finds the second largest element in the array.
     * @param nums The input array of integers.
     * @return The second largest value, or -1 if it doesn't exist.
     */
    public int secondLargestElement(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            } else if (nums[i] > secondLargest && nums[i] != largest) {
                secondLargest = nums[i];
            }
        }
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }

    public static void main(String[] args) {
        SecondLargestElement sol = new SecondLargestElement();

        // Example 1
        int[] nums1 = {8, 8, 7, 6, 5};
        System.out.println("Input: [8, 8, 7, 6, 5]");
        System.out.println("Output: " + sol.secondLargestElement(nums1)); // Expected: 7

        // Example 2
        int[] nums2 = {10, 10, 10, 10, 10};
        System.out.println("\nInput: [10, 10, 10, 10, 10]");
        System.out.println("Output: " + sol.secondLargestElement(nums2)); // Expected: -1

        // Example 3
        int[] nums3 = {7, 7, 2, 2, 10, 10, 10};
        System.out.println("\nInput: [7, 7, 2, 2, 10, 10, 10]");
        System.out.println("Output: " + sol.secondLargestElement(nums3)); // Expected: 7
    }
}
