import java.util.Arrays;

public class CountWaysToBuildGoodStrings2466 {
    public static void main(String[] args) {
        System.out.println(new Solution().countGoodStrings(200, 200, 10, 1));
    }

    private static class Solution {
        private static final int MOD = 1000000007;
        public int countGoodStrings(int low, int high, int zero, int one) {
            int[] dp = new int[high + 1];
            dp[0] = 1;
            for (int i = Math.min(zero, one); i <= high; i++) {
                if (i - zero >= 0) {
                    dp[i] += dp[i - zero];
                    dp[i] %= MOD;
                }

                if (i - one >= 0) {
                    dp[i] += dp[i - one];
                    dp[i] %= MOD;
                }
            }
            System.out.println(Arrays.toString(dp));
            int count = 0;
            for (int i = low; i <= high; i++) {
                count += dp[i];
                count %= MOD;
            }
            return count;
        }
    }
}
