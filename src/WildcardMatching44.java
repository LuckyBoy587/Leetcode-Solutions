public class WildcardMatching44 {
    public static void main(String[] args) {
        String s1 = "abcabczzzde";
        String s2 = "*abc???de*";
        System.out.println(new Solution().isMatch(s1, s2));
    }

    private static class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length(), n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[0][j] = true;
                } else {
                    break;
                }
            }

            for (int i = 1; i <= m; i++) {
                char c1 = s.charAt(i - 1);
                for (int j = 1; j <= n; j++) {
                    char c2 = p.charAt(j - 1);
                    if (isSameChar(c1, c2)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (c2 == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }

            return dp[m][n];
        }

        public boolean isSameChar(char c1, char c2) {
            return c1 == c2 || c2 == '?';
        }
    }
}
