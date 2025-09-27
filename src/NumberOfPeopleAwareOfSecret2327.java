import java.util.Arrays;

public class NumberOfPeopleAwareOfSecret2327 {
    private static class Solution {
        public int peopleAwareOfSecret(int n, int delay, int forget) {
            long MOD = 1_000_000_007;
            long[] dp = new long[n + 1];
            long curr = 1;
            dp[1] = 1;
            for (int day = 2; day <= n; day++) {
                if (day - delay >= 1) {
                    curr += dp[day - delay];
                }

                if (day - forget >= 1) {
                    curr -= dp[day - forget];
                }
                curr %= MOD;
                dp[day] = curr;
            }

            System.out.println(Arrays.toString(dp));
            return (int) curr;
        }
    }
}
