public class LongestPalindrome2131 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome(new String[]{"lc","cl","gg"}));
    }
    private static class Solution {
        public int longestPalindrome(String[] words) {
            int[][] freq = new int[26][26];
            for (String word : words) {
                int l1 = word.charAt(0) - 'a';
                int l2 = word.charAt(1) - 'a';
                freq[l1][l2] += 1;
            }

            int res = 0;
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < i; j++) {
                    res += Math.min(freq[i][j], freq[j][i]);
                }
            }

            boolean oddExists = false;
            for (int i = 0; i < 26; i++) {
                res += freq[i][i] / 2;
                oddExists |= freq[i][i] % 2 == 1;
            }

            return (res * 2 + (oddExists ? 1: 0)) * 2;
        }
    }
}
