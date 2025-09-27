public class CyclicSubstring2825 {
    public static void main(String[] args) {
        System.out.println(new Solution().canMakeSubsequence("abc", "ad"));
    }
    private static class Solution {
        public boolean canMakeSubsequence(String str1, String str2) {
            int i = 0, j = 0;
            char[] word1 = str1.toCharArray();
            char[] word2 = str2.toCharArray();

            while (i < word1.length && j < word2.length) {
                if (word1[i] == word2[j] || word1[i] + 1 == word2[j] || word1[i] == 'z' && word2[j] == 'a') {
                    j++;
                }
                i++;
            }
            return j == word2.length;
        }
    }
}
