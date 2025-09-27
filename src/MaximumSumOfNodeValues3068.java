public class MaximumSumOfNodeValues3068 {
    private static class Solution {
        public long maximumValueSum(int[] nums, int k, int[][] edges) {
            int n = nums.length;

            for (int[] edge: edges) {
                int currVal = nums[edge[0]] + nums[edge[1]];
                int newVal = nums[edge[0]] ^ k + nums[edge[1]] ^ k;

                if (newVal > currVal) {
                    nums[edge[0]] ^= k;
                    nums[edge[1]] ^= k;
                }
            }

            long res = 0;
            for (int i = 0; i < n; i++) {
                res += nums[i];
            }

            return res;
        }
    }
}
