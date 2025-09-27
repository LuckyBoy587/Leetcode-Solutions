public class MaximumRepeatingSubstring1668 {
    private static class Solution {
        public int maxRepeating(String sequence, String word) {
            return maxRepeating(sequence, word, new StringBuilder(word));
        }

        public int maxRepeating(String sequence, String word, StringBuilder curr) {
            if (!sequence.contains(curr)) return 0;
            return 1 + maxRepeating(sequence, word, curr.append(word));
        }
    }
}
