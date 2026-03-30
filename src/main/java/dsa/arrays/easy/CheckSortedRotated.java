/**
 * 📝 Problem Name: Check if Array Is Sorted and Rotated
 * 🌐 Platform: LeetCode
 * ⚡ Approach: Circular check - Count drops in order (nums[i] > nums[(i+1)%n]). 
 *    A sorted and rotated array can have at most one such drop.
 * ⏱ Time Complexity: O(N)
 * 📦 Space Complexity: O(1)
 */

package dsa.arrays.easy;

import java.util.*;

public class CheckSortedRotated {
    /**
     * Checks if the array was originally sorted and then rotated.
     * @param nums The input array of integers.
     * @return true if sorted and rotated, false otherwise.
     */
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // circular comparison
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        // If count <= 1, it means there's at most one point where the order breaks.
        return count <= 1;
    }

    public static void main(String[] args) {
        CheckSortedRotated sol = new CheckSortedRotated();

        // Example 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Input: [3, 4, 5, 1, 2]");
        System.out.println("Output: " + sol.check(nums1)); // Expected: true

        // Example 2
        int[] nums2 = {2, 1, 3, 4};
        System.out.println("\nInput: [2, 1, 3, 4]");
        System.out.println("Output: " + sol.check(nums2)); // Expected: false

        // Example 3
        int[] nums3 = {1, 2, 3};
        System.out.println("\nInput: [1, 2, 3]");
        System.out.println("Output: " + sol.check(nums3)); // Expected: true
    }
}
