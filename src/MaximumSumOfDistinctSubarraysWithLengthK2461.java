public class MaximumSumOfDistinctSubarraysWithLengthK2461 {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumSubarraySum(new int[]{9, 9, 9, 1, 2, 3}, 3));
    }

    private static class Solution {
        public long maximumSubarraySum(int[] nums, int k) {
            int maxVal = nums[0];
            for (int i = 1; i < nums.length; i++) {
                maxVal = Math.max(maxVal, nums[i]);
            }

            int[] freq = new int[maxVal + 1];
            long res = 0, windowSum = 0;
            int uniqueCount = 0;

            for (int i = 0; i < nums.length; i++) {
                windowSum += nums[i];
                if (freq[nums[i]] == 0) {
                    ++uniqueCount;
                }
                freq[nums[i]]++;

                if (i + 1 >= k) {
                    if (uniqueCount == k) {
                        res = Math.max(res, windowSum);
                    }
                    freq[nums[i + 1 - k]]--;
                    windowSum -= nums[i + 1 - k];
                    if (freq[nums[i + 1 - k]] == 0) {
                        --uniqueCount;
                    }
                }
            }

            return res;
        }
    }
}
