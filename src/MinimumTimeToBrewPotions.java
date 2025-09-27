public class MinimumTimeToBrewPotions {
    public static void main(String[] args) {
        int[] skill = {1, 5, 2, 4};
        int[] mana = {5, 1, 4, 2};
        System.out.println(new Solution().minTime(skill, mana));
    }

    private static class Solution {
        public long minTime(int[] skill, int[] mana) {
            int m = mana.length;
            int n = skill.length;
            long[][] dp = new long[m][n + 1];
            for (int j = 1; j <= n; j++) {
                dp[0][j] = dp[0][j - 1] + (long) skill[j - 1] * mana[0];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i][j - 1] + (long) skill[j - 1] * mana[i];

                }
                long baseStart = findStart(0, dp[i - 1][n], dp, i);
                for (int k = 0; k <= n; k++) {
                    dp[i][k] += baseStart;
                }
            }

            return dp[m - 1][n];
        }

        private long findStart(long left, long right, long[][] dp, int potion) {
            long res = Integer.MAX_VALUE;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (isPossibleStart(potion, mid, dp)) {
                    res = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return res;
        }

        private boolean isPossibleStart(int potion, long start, long[][] dp) {
            for (int j = 0; j + 1 < dp[potion].length; j++) {
                if (dp[potion][j] + start < dp[potion - 1][j + 1]) {
                    return false;
                }
            }

            return true;
        }
    }
}
