import java.util.Arrays;

public class CountVowels2559 {
    public static void main(String[] args) {
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        System.out.println(Arrays.toString(new Solution().vowelStrings(words, queries)));
    }

    private static class Solution {
        public int[] vowelStrings(String[] words, int[][] queries) {
            int n = words.length;
            int[] prefixSum = new int[n];
            for (int i = 0; i < n; i++) {
                prefixSum[i] = isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1)) ? 1 : 0;
            }

            for (int i = 1; i < n; i++) {
                prefixSum[i] += prefixSum[i - 1];
            }

            int[] result = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                result[i] = prefixSum[queries[i][1]];
                if (queries[i][0] > 0) result[i] -= prefixSum[queries[i][0] - 1];
            }
            return result;
        }

        private boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
    }
}
