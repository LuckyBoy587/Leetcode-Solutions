public class ScoreAfterSplitting1422 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxScore("011101"));
    }
    private static class Solution {
        public int maxScore(String s) {
            char[] letters = s.toCharArray();
            int n = letters.length;
            int[] leftZeroCount = new int[n];
            int[] rightOneCount = new int[n];
            leftZeroCount[0] = letters[0] == '0' ? 1 : 0;
            rightOneCount[n - 1] = letters[n - 1] == '1' ? 1 : 0;

            for (int i = 1; i < n - 1; i++) {
                leftZeroCount[i] = leftZeroCount[i - 1] + (letters[i] == '0' ? 1 : 0);
            }

            for (int i = n - 2; i >= 0; i--) {
                rightOneCount[i] = rightOneCount[i + 1] + (letters[i] == '1' ? 1 : 0);
            }

            int maxScore = 0;
            for (int i = 1; i < n; i++) {
                maxScore = Math.max(maxScore, leftZeroCount[i - 1] + rightOneCount[i]);
            }

            return maxScore;
        }
    }
}
