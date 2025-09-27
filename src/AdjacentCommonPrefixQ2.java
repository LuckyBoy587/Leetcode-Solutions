public class AdjacentCommonPrefixQ2 {
    private static class Solution {
        public int[] longestCommonPrefix(String[] words) {
            int n = words.length;
            int[] prefixLength = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                prefixLength[i] = getLongestCommonPrefix(words[i], words[i + 1]);
            }

            int[] leftMax = new int[n];
            for (int i = 2; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], prefixLength[i - 2]);
            }

            int[] rightMax = new int[n];
            for (int i = n - 3; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], prefixLength[i + 1]);
            }

            int[] res = new int[n];
            res[0] = rightMax[0];
            res[n - 1] = leftMax[n - 1];
            for (int i = 1; i < n - 1; i++) {
                res[i] = Math.max(Math.max(leftMax[i], rightMax[i]), getLongestCommonPrefix(words[i - 1], words[i + 1]));
            }

            return res;
        }

        private int getLongestCommonPrefix(String word1, String word2) {
            int i = 0;
            while (i < word1.length() && i < word2.length()) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    break;
                }
                i++;
            }
            return i;
        }
    }
}
