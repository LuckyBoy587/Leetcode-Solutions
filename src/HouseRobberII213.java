public class HouseRobberII213 {
    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{2,2}));
    }
    private static class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) return nums[0];
            if (nums.length == 2) return Math.max(nums[0], nums[1]);
            return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
        }

        private int rob(int[] nums, int start, int end) {
            int[] dp = new int[end - start];
            dp[0] = nums[start];
            dp[1] = Math.max(nums[start], nums[start + 1]);
            for (int i = 2; i < dp.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i + start], dp[i - 1]);
            }
            return dp[dp.length - 1];
        }
    }
}
