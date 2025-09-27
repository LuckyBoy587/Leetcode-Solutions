public class LongestSubarrayWithBitwiseAND2419 {
    private static class Solution {
        public int longestSubarray(int[] nums) {
            int maxValue = nums[0];
            for (int val : nums) {
                maxValue = Math.max(maxValue, val);
            }
            int res = 0, index = 0;
            while (index < nums.length) {
                if (nums[index] != maxValue) index++;
                else {
                    int currLen = 0;
                    while (index < nums.length && nums[index] == maxValue) {
                        currLen++;
                        index++;
                    }
                    res = Math.max(res, currLen);
                }
            }

            return res;
        }
    }
}
