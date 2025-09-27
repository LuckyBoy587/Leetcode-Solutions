import java.util.Arrays;

public class LongestNiceSubarray2401 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestNiceSubarray(new int[]{2, 1, 1, 4}));
    }

    private static class Solution {
        public int longestNiceSubarray(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);

            for (int i = 1; i < n; i++) {
                for (int j = i - 1; j >= i - dp[i - 1] && (nums[i] & nums[j]) == 0; j--) {
                    dp[i]++;
                }
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
