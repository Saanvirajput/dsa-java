/**
 * 📝 Problem Name: Longest Subarray with Sum K (Includes Positives, Negatives, and Zeros)
 * 🌐 Platform: DSA Practice
 * ⚡ Approach: Hashing (Prefix Sum)
 *    - Maintain a prefix sum 'sum' and store its first occurrence index in a map.
 *    - If (sum - k) is found in the map, the subarray between that index and current index sums to k.
 * ⏱ Time Complexity: O(N) or O(N log N) depending on the Map implementation (HashMap is O(1) average).
 * 📦 Space Complexity: O(N) to store the prefix sums in the map.
 */

package dsa.arrays.medium;

import java.util.*;

public class LongestSubarraySumHashed {
    /**
     * Finds the length of the longest subarray with sum k using hashing.
     * Works for arrays with positives, negatives, and zeros.
     * @param nums The input array.
     * @param k The target sum.
     * @return The maximum length.
     */
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            // Case 1: Prefix sum itself is k
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // Case 2: (sum - k) exists in the map
            long rem = sum - k;
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // Case 3: Only store the FIRST occurrence of a sum to maximize length
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubarraySumHashed sol = new LongestSubarraySumHashed();

        // Example 1
        int[] nums1 = {10, 5, 2, 7, 1, 9};
        int k1 = 15;
        System.out.println("Input: nums = [10, 5, 2, 7, 1, 9], k = 15");
        System.out.println("Output: " + sol.longestSubarray(nums1, k1)); // Expected: 4

        // Example 2 (With Negatives)
        int[] nums2 = {-3, 2, 1};
        int k2 = 6;
        System.out.println("\nInput: nums = [-3, 2, 1], k = 6");
        System.out.println("Output: " + sol.longestSubarray(nums2, k2)); // Expected: 0
    }
}
