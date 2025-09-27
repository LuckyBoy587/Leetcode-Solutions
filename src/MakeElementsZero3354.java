public class MakeElementsZero3354 {
    private static class Solution {
        public int countValidSelections(int[] nums) {
            int n = nums.length;
            int[] prefixSum = new int[n];
            prefixSum[0] = nums[0];
            for (int i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }

            int[] suffixSum = new int[n];
            suffixSum[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                suffixSum[i] = suffixSum[i + 1] + nums[i];
            }

            int count = 0;
            for (int i = 1; i < n - 1; i++) {
                if (nums[i] == 0) {
                    if (prefixSum[i - 1] == suffixSum[i + 1]) {
                        count += 2;
                    } else if (Math.abs(prefixSum[i - 1] - suffixSum[i + 1]) == 1) {
                        count += 1;
                    }
                }
            }
            return count;
        }
    }
}
