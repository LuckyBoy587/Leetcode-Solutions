public class WaysToExpress2787 {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfWays(4, 1));
    }

    private static class Solution {
        private static final int MOD = 1000000007;
        int[] powers;
        Integer[][] memo;

        public int numberOfWays(int n, int x) {
            int maxNumbers = (int) Math.ceil(Math.pow(n, 1.0 / x)) + 1;
            powers = new int[maxNumbers];
            for (int i = 1; i < maxNumbers; i++) {
                powers[i] = (int) Math.pow(i, x);
            }
            memo = new Integer[n + 1][maxNumbers];
            return dfs(n, 1);
        }

        private int dfs(int n, int index) {
            if (n == 0) return 1;
            if (n < 0 || index == powers.length) return 0;
            if (memo[n][index] != null) return memo[n][index];
            int pick = dfs(n - powers[index], index + 1) % MOD;
            int notPick = dfs(n, index + 1) % MOD;
            return memo[n][index] = (pick + notPick) % MOD;
        }
    }
}
