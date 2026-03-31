/**
 * 📝 Problem Name: Single Number
 * 🌐 Platform: LeetCode (136)
 * ⚡ Approach: XOR Operation.
 *    - XORing a number with itself results in 0 (a ^ a = 0).
 *    - XORing a number with 0 results in the number itself (a ^ 0 = a).
 *    - Since all numbers except one appear twice, XORing all elements will leave the single number.
 * ⏱ Time Complexity: O(N) where N is the length of the array.
 * 📦 Space Complexity: O(1) as we use only one variable.
 */

package dsa.arrays.easy;

import java.util.Arrays;

public class SingleNumber {
    /**
     * Finds the element that appears only once in an array where every other element appears twice.
     * @param nums Array where each element appears twice except for one.
     * @return The single element.
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber sol = new SingleNumber();

        // Example 1
        int[] nums1 = {2, 2, 1};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + sol.singleNumber(nums1)); // Expected: 1

        // Example 2
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Output: " + sol.singleNumber(nums2)); // Expected: 4

        // Example 3
        int[] nums3 = {1};
        System.out.println("\nInput: " + Arrays.toString(nums3));
        System.out.println("Output: " + sol.singleNumber(nums3)); // Expected: 1
    }
}
