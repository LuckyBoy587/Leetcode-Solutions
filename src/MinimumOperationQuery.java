public class MinimumOperationQuery {
    private static class Solution {
        public static int[] minOperation(String s, int[][] queries) {
            int[] vowelCount = new int[s.length()];
            vowelCount[0] = isVowel(s.charAt(0)) ? 1 : 0;
            for (int i = 1; i < s.length(); i++) {
                vowelCount[i] = vowelCount[i - 1] + (isVowel(s.charAt(i)) ? 1 : 0);
            }

            int[] result = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int st = queries[i][0];
                int end = queries[i][1];
                int vowels = vowelCount[end];
                if (st > 0) vowels -= vowelCount[st - 1];
                int distance = end - st + 1;
            }
            return result;
        }

        private static boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
    }
}
