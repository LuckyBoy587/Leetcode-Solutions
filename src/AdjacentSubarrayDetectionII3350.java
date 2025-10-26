import java.util.*;

/**
 * Given an array nums of n integers, your task is to find the maximum value of k for which there exist two adjacent subarrays of length k each, such that both subarrays are strictly increasing. Specifically, check if there are two subarrays of length k starting at indices a and b (a < b), where:
 * - Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
 * - The subarrays must be adjacent, meaning b = a + k.
 *
 * Return the maximum possible value of k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example 1:
 * Input: nums = [2,5,7,8,9,2,3,4,3,1]
 * Output: 3
 * Explanation:
 * - The subarray starting at index 2 is [7, 8, 9], which is strictly increasing.
 * - The subarray starting at index 5 is [2, 3, 4], which is also strictly increasing.
 * - These two subarrays are adjacent, and 3 is the maximum possible value of k for which two such adjacent strictly increasing subarrays exist.
 *
 * Example 2:
 * Input: nums = [1,2,3,4,4,4,4,5,6,7]
 * Output: 2
 * Explanation:
 * - The subarray starting at index 0 is [1, 2], which is strictly increasing.
 * - The subarray starting at index 2 is [3, 4], which is also strictly increasing.
 * - These two subarrays are adjacent, and 2 is the maximum possible value of k for which two such adjacent strictly increasing subarrays exist.
 *
 * Constraints:
 * - 2 <= nums.length <= 2 * 10^5
 * - -10^9 <= nums[i] <= 10^9
 */
public class AdjacentSubarrayDetectionII3350 {

    public static void main(String[] args) {
        Solution sol = new Solution();
 
        // Test 1
        List<Integer> nums1 = Arrays.asList(2,5,7,8,9,2,3,4,3,1);
        int expected1 = 3;
        int result1 = sol.maxIncreasingSubarrays(nums1);
        if (result1 == expected1) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 failed: expected " + expected1 + ", got " + result1);
        }

        // Test 2
        List<Integer> nums2 = Arrays.asList(1,2,3,4,4,4,4,5,6,7);
        int expected2 = 2;
        int result2 = sol.maxIncreasingSubarrays(nums2);
        if (result2 == expected2) {
            System.out.println("Test 2 passed");
        } else {
            System.out.println("Test 2 failed: expected " + expected2 + ", got " + result2);
        }
    }

    private static class Solution {
        public int maxIncreasingSubarrays(List<Integer> nums) {
            int prevLen = 0, currLen = 0, maxLen = 0;
            int prevNum = -10001;
            int res = 0;
            for (int num : nums) {
                if (num > prevNum) currLen++;
                else {
                    res = Math.max(res, Math.min(currLen, prevLen));
                    maxLen = Math.max(maxLen, currLen);
                    prevLen = currLen;
                    currLen = 1;
                }
                prevNum = num;
            }

            maxLen = Math.max(maxLen, currLen);
            res = Math.max(res, Math.min(currLen, prevLen));
            return Math.max(maxLen / 2, res);
        }
    }
}