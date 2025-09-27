public class MaxFrequencyAfterSubarrayOperation {
    private static class Solution {
        public int maxFrequency(int[] nums, int k) {
            int targetCount = 0, maxKey = 0;
            for (int num : nums) {
                if (num == k) targetCount++;
                maxKey = Math.max(maxKey, num);
            }

            int res = targetCount;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == k) {
                    continue;
                }
                int[] freqArr = new int[maxKey + 1];
                int maxFreqValue = 0;
                for (int j = i; j < nums.length; j++) {
                    int currFreq = ++freqArr[nums[j]];
                    if (currFreq > maxFreqValue) {
                        maxFreqValue = currFreq;
                    }
                    res = Math.max(res, maxFreqValue + (targetCount > 0 ? targetCount - freqArr[k]: 0));
                }
            }

            return res;
        }
    }
}
