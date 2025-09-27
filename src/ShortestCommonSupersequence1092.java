public class ShortestCommonSupersequence1092 {
    private static class Solution {
        public String shortestCommonSupersequence(String str1, String str2) {
            char[] letters1 = str1.toCharArray();
            char[] letters2 = str2.toCharArray();
            return longestCommonSubsequence(letters1, letters2);
        }

        private String longestCommonSubsequence(char[] str1, char[] str2) {
            int m = str1.length;
            int n = str2.length;

            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (str1[i - 1] == str2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            StringBuilder res = new StringBuilder();
            int i = m, j = n;
            while (i > 0 && j > 0) {
                if (str1[i - 1] == str2[j - 1]) {
                    res.append(str1[i - 1]);
                    i--;
                    j--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    res.append(str1[i - 1]);
                    i--;
                } else {
                    res.append(str2[j - 1]);
                    j--;
                }
            }

            while (i > 0) {
                res.append(str1[--i]);
            }

            while (j > 0) {
                res.append(str2[--j]);
            }

            return res.reverse().toString();
        }
    }
}
