import java.util.Arrays;

public class MaximumValidSubsequence3202 {
    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 3, 1, 4};
        int k = 3;
        Solution solution = new Solution();
        System.out.println(solution.maximumLength(nums, k));
    }
    private static class Solution {
        public int maximumLength(int[] nums, int k) {
            int[][] dp = new int[nums.length][k];
            int res = 0;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    int mod = (nums[i] + nums[j]) % k;
                    dp[i][mod] = Math.max(2, Math.max(dp[i][mod], dp[j][mod] + 1));
                    res = Math.max(res, dp[i][mod]);
                }
            }

            System.out.println(Arrays.deepToString(dp));
            return res;
        }
    }
}
