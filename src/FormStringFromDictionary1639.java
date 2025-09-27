public class FormStringFromDictionary1639 {
    public static void main(String[] args) {
        String[] words = {"acca", "bbbb", "caca"};
        System.out.println(new Solution().numWays(words, "aba"));
    }

    private static class Solution {
        private static final int MOD = 1000000007;
        int[][] freq, memo;

        public int numWays(String[] words, String target) {
            int m = words[0].length();
            int n = target.length();

            memo = new int[m][n];
            freq = new int[m][26];

            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    freq[i][word.charAt(i) - 'a']++;
                }
            }

            return find(0, 0, target);
        }

        private int find(int wordIndex, int targetIndex, String target) {
            if (targetIndex == target.length()) return 1;
            if (wordIndex == memo.length) return 0;
            if (memo[wordIndex][targetIndex] != 0) return memo[wordIndex][targetIndex];

            int count = 0;
            int letterIndex = target.charAt(targetIndex) - 'a';

            if (freq[wordIndex][letterIndex] > 0) {
                count += (int) ((long) freq[wordIndex][letterIndex] * find(wordIndex + 1, targetIndex + 1, target) % MOD);
            }

            count += find(wordIndex + 1, targetIndex, target) % MOD;
            return memo[wordIndex][targetIndex] = count;
        }
    }

}
