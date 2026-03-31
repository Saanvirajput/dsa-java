/**
 * 📝 Problem Name: Remove Duplicates from Sorted Array
 * 🌐 Platform: LeetCode (26)
 * ⚡ Approach: Two-pointer technique.
 *    - Use one pointer 'i' to track the position for the next unique element.
 *    - Use another pointer 'j' to traverse the array and find unique elements.
 * ⏱ Time Complexity: O(N) where N is the length of the array.
 * 📦 Space Complexity: O(1) as we are modifying the array in-place.
 */

package dsa.arrays.easy;

import java.util.Arrays;

public class RemoveDuplicates {
    /**
     * Removes duplicates in-place from a sorted array and returns the count of unique elements.
     * @param nums Sorted integer array.
     * @return The number of unique elements.
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;


        int i = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicates sol = new RemoveDuplicates();

        // Example 1
        int[] nums1 = {1, 1, 2};
        System.out.println("Input: " + Arrays.toString(nums1));
        int k1 = sol.removeDuplicates(nums1);
        System.out.println("Output: " + k1);
        System.out.print("Array After Removal: ");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + (i == k1 - 1 ? "" : ", "));
        }
        System.out.println();

        // Example 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("\nInput: " + Arrays.toString(nums2));
        int k2 = sol.removeDuplicates(nums2);
        System.out.println("Output: " + k2);
        System.out.print("Array After Removal: ");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + (i == k2 - 1 ? "" : ", "));
        }
        System.out.println();
    }
}
