public class LongestPalindromeAfterConcatenation {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abcde", "ecdba"));
    }
    private static class Solution {
        int[][] dp;
        public int longestPalindrome(String s, String t) {
            char[] word = (s + t).toCharArray();
            int n = word.length;
            dp = new int[n][n];
            return find(word, 0, n - 1);
        }

        private int find(char[] word, int i, int j) {
            if (i == j) return 1;
            if (dp[i][j] != 0) return dp[i][j];
            if (word[i] == word[j]) {
                if (i + 1 == j) return 2;
                return 2 + find(word, i + 1, j - 1);
            }
            return dp[i][j] = Math.max(find(word, i + 1, j), find(word, i, j - 1));
        }
    }
}
