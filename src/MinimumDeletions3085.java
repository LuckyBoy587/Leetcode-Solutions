public class MinimumDeletions3085 {
    private static class Solution {
        public int minimumDeletions(String word, int k) {
            int[] freqArr = new int[26];
            for (char c: word.toCharArray()) {
                freqArr[c - 'a']++;
            }

            int res = word.length();
            for (int freq: freqArr) {
                res = Math.min(res, deletionsMade(freqArr, freq, freq + k));
            }

            return res;
        }

        private int deletionsMade(int[] freqArr, int rangeStart, int rangeEnd) {
            int deletions = 0;

            for (int freq: freqArr) {
                if (freq < rangeStart) {
                    deletions += freq;
                } else if (freq > rangeEnd) {
                    deletions += freq - rangeEnd;
                }
            }

            return deletions;
        }
    }
}
