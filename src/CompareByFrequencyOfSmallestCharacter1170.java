public class CompareByFrequencyOfSmallestCharacter1170 {
    private static class Solution {
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            int[] freqCount = new int[11];
            for (String word : words) {
                freqCount[f(word)]++;
            }
            for (int i = freqCount.length - 2; i >= 0; i--) {
                freqCount[i] += freqCount[i + 1];
            }
            int[] result = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                result[i] = freqCount[f(queries[i]) + 1];
            }
            return result;
        }

        private int f(String word) {
            int count = 0;
            char smallest = 'z';
            for (char letter: word.toCharArray()) {
                if (letter == smallest) {
                    count++;
                } else if (letter < smallest) {
                    smallest = letter;
                    count = 1;
                }
            }
            return count;
        }
    }
}
