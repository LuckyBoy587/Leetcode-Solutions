public class LetterTilePossibilities1079 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTilePossibilities("AAB"));
    }

    private static class Solution {
        public int numTilePossibilities(String tiles) {
            int[] freq = new int[26];
            for (char letter : tiles.toCharArray()) {
                freq[letter - 'A']++;
            }
            return search(freq, tiles.length()) - 1;
        }

        private int search(int[] freq, int depth) {
            if (depth == 0) return 1;
            int res = 1;
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > 0) {
                    freq[i]--;
                    res += search(freq, depth - 1);
                    freq[i]++;
                }
            }
            return res;
        }
    }
}
