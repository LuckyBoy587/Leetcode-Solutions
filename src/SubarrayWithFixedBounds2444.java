public class SubarrayWithFixedBounds2444 {
    private static class Solution {
        public long countSubarrays(int[] nums, int minK, int maxK) {
            long res = 0;
            int lastMinIndex = -1, lastMaxIndex = -1, lastInvalidIndex = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == minK) lastMinIndex = i;
                else if (nums[i] == maxK) lastMaxIndex = i;
                else if (nums[i] < minK || nums[i] > maxK) lastInvalidIndex = i;

                int validStartCount = Math.min(lastMinIndex, lastMaxIndex) - lastInvalidIndex + 1;
                if (validStartCount > 0) {
                    res += validStartCount;
                }
            }

            return res;
        }
    }
}
