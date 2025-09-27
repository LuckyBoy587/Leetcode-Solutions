import java.util.Scanner;

public class RegexMatching10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        System.out.println(new Solution().isMatch(s, p));
    }
    private static class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();

            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;

            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[0][j] = dp[0][j - 2];
                }
            }

            for (int i = 1; i <= m; i++) {
                char c1 = s.charAt(i - 1);
                for (int j = 1; j <= n; j++) {
                    char c2 = p.charAt(j - 1);
                    if (isMatchingCharacters(c1, c2)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (c2 == '*') {
                        dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && isMatchingCharacters(c1, p.charAt(j - 2)));
                    }
                }
            }

            return dp[m][n];
        }

        private boolean isMatchingCharacters(char c1, char c2) {
            return c1 == c2 || c2 == '.';
        }
    }
}
