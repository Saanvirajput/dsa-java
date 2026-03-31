/**
 * 📝 Problem Name: Longest Subarray with Sum K (Only Positives and Zeros)
 * 🌐 Platform: DSA Practice
 * ⚡ Approach: Two-pointer/Sliding Window
 *    - Maintain a window [left, right] whose elements sum to k.
 *    - Expand the window by incrementing the right pointer.
 *    - If the sum exceeds k, shrink the window by incrementing the left pointer.
 * ⏱ Time Complexity: O(2N) ≈ O(N) as each element is visited at most twice (by left and right pointers).
 * 📦 Space Complexity: O(1) as we use only a few extra variables.
 */

package dsa.arrays.medium;

import java.util.Arrays;

public class LongestSubarraySumSlidingWindow {
    /**
     * Finds the length of the longest subarray with sum k using the sliding window technique.
     * Note: This efficient approach ONLY works for arrays with positive numbers and zeros.
     * @param nums The input array (positives/zeros).
     * @param k The target sum.
     * @return The maximum length.
     */
    public int longestSubarray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int maxLen = 0;
        int left = 0, right = 0;
        long sum = nums[0];

        while (right < n) {
            // Shrink window if sum exceeds k
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            // Check if sum matches target
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Expand window
            right++;
            if (right < n) {
                sum += nums[right];
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubarraySumSlidingWindow sol = new LongestSubarraySumSlidingWindow();

        // Example 1
        int[] nums1 = {1, 2, 3, 1, 1, 1, 1};
        int k1 = 3;
        System.out.println("Input: nums = [1, 2, 3, 1, 1, 1, 1], k = 3");
        System.out.println("Output: " + sol.longestSubarray(nums1, k1)); // Expected: 3

        // Example 2
        int[] nums2 = {10, 5, 2, 7, 1, 9};
        int k2 = 15;
        System.out.println("\nInput: nums = [10, 5, 2, 7, 1, 9], k = 15");
        System.out.println("Output: " + sol.longestSubarray(nums2, k2)); // Expected: 4
    }
}
