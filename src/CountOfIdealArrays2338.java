import java.util.ArrayList;
import java.util.List;

public class CountOfIdealArrays2338 {
    private static class Solution {
        int MOD = 1000_000_007;
        public int idealArrays(int n, int maxValue) {
            long[][] dp = new long[n + 1][maxValue + 1];
            for (int value = 1; value <= maxValue; value++) {
                dp[1][value] = 1;
            }

            List<Integer>[] divisors = new List[maxValue + 1];
            for (int i = 1; i <= maxValue; i++) {
                divisors[i] = new ArrayList<>();
            }

            for (int divisor = 1; divisor <= maxValue; divisor++) {
                for (int value = divisor; value <= maxValue; value += divisor) {
                    divisors[value].add(divisor);
                }
            }

            for (int length = 2; length <= n; length++) {
                for (int value = 1; value <= maxValue; value++) {
                    dp[length][value] = dp[length - 1][value];
                    for (int divisor: divisors[value]) {
                        if (value % divisor == 0) {
                            dp[length][value] = (dp[length][value] + dp[length - 1][divisor]) % MOD;
                        }
                    }
                    if (value > 1) {
                        dp[length][value] = (dp[length][value] + dp[length - 1][1]) % MOD;
                    }
                }

//                for (int divisor = 1; divisor <= maxValue; divisor++) {
//                    for (int k = 1; divisor * k <= maxValue; k++) {
//                        int value = divisor * k;
//                        dp[length][value] = (dp[length][value] + dp[length - 1][divisor]) % MOD;
//                    }
//                }
            }
//            for (long[] row: dp) {
//                System.out.println(Arrays.toString(row));
//            }

            long res = 0;
            for (int value = 1; value <= maxValue; value++) {
                res = (res + dp[n][value]) % MOD;
            }
            return (int) (res);
        }
    }
}
