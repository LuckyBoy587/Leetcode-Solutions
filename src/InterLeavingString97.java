public class InterLeavingString97 {
    public static void main(String[] args) {
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    private static class Solution {
        Boolean[][] memo;

        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) return false;
            memo = new Boolean[s1.length() + 1][s2.length() + 1];
            return check(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0);
        }

        public boolean check(char[] s1, char[] s2, char[] s3, int i, int j, int k) {
            if (k == s3.length) return true;
            if (memo[i][j] != null) return memo[i][j];
            if (i < s1.length && s1[i] == s3[k] && check(s1, s2, s3, i + 1, j, k + 1)) {
                return memo[i][j] = true;
            }

            return memo[i][j] = j < s2.length && s2[j] == s3[k] && check(s1, s2, s3, i, j + 1, k + 1);
        }
    }
}
