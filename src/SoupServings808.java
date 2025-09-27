public class SoupServings808 {
    public static void main(String[] args) {
        System.out.println(new Solution().soupServings(1));
    }

    private static class Solution {
        int[][] picks = {{4, 0}, {3, 1}, {2, 2}, {1, 3}};
        Double[][] dp;

        public double soupServings(int n) {
            if (n >= 5000) return 1.0;
            n = (int) Math.ceil(n / 25.0);
            dp = new Double[n + 1][n + 1];
            return count(n, n);
        }

        private double count(int soupA, int soupB) { // prob A before B, prob A and B
            if (soupA == 0 && soupB == 0) return 0.5;
            if (soupA == 0) return 1;
            if (soupB == 0) return 0;
            if (dp[soupA][soupB] != null) return dp[soupA][soupB];

            double res = 0;
            for (int[] pick : picks) {
                res += count(Math.max(0, soupA - pick[0]), Math.max(0, soupB - pick[1]));
            }

            return dp[soupA][soupB] = res * 0.25;
        }
    }
}
