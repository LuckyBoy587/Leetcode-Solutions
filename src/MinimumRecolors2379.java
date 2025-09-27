public class MinimumRecolors2379 {
    private static class Solution {
        public int minimumRecolors(String blocks, int k) {
            int res = Integer.MAX_VALUE;
            int windowWhite = 0;
            char[] letters = blocks.toCharArray();

            for (int i = 0; i < k; i++) {
                if (letters[i] == 'W') windowWhite++;
            }

            for (int i = k; i < letters.length; i++) {
                if (letters[i] == 'W') windowWhite++;
                res = Math.min(res, windowWhite);
                if (letters[i - k] == 'W') windowWhite--;
            }

            return res;
        }
    }
}
