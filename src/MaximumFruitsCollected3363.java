public class MaximumFruitsCollected3363 {
    public static void main(String[] args) {
        int[][] fruits = {
                {16, 3, 11, 14, 14},
                {3, 0, 10, 13, 14},
                {7, 18, 8, 7, 18},
                {7, 8, 5, 7, 5},
                {0, 14, 8, 1, 0}
        };
        System.out.println("Maximum fruits collected: " + new Solution().maxCollectedFruits(fruits));
    }

    private static class Solution {
        public int maxCollectedFruits(int[][] fruits) {
            int diagonal = 0, n = fruits.length;
            for (int i = 0; i < n; i++) {
                diagonal += fruits[i][i];
            }

            return diagonal + bottom(fruits) + top(fruits);
        }

        private int bottom(int[][] fruits) {
            int n = fruits.length;
            int[][] dp = new int[n][n];
            dp[n - 1][0] = fruits[n - 1][0];
            for (int j = 1; j < n; j++) {
                for (int i = n - 1; i >= n / 2 && i >= n - j - 1; i--) {
                    int prevBottom = i + 1 < n ? dp[i + 1][j - 1] : 0;
                    int prevLeft = dp[i][j - 1];
                    int prevTop = dp[i - 1][j - 1];
                    dp[i][j] = Math.max(prevBottom, Math.max(prevLeft, prevTop)) + fruits[i][j];
                }
            }

            return dp[n - 1][n - 2];
        }

        private int top(int[][] fruits) {
            int n = fruits.length;
            int[][] dp = new int[n][n];
            dp[0][n - 1] = fruits[0][n - 1];
            for (int i = 1; i < n; i++) {
                for (int j = n - 1; j >= n / 2 && j >= n - i - 1; j--) {
                    int prevLeft = dp[i - 1][j - 1];
                    int prevTop = dp[i - 1][j];
                    int prevRight = j + 1 < n ? dp[i - 1][j + 1] : 0;
                    dp[i][j] = Math.max(prevLeft, Math.max(prevTop, prevRight)) + fruits[i][j];
                }
            }

            return dp[n - 2][n - 1];
        }
    }
}
