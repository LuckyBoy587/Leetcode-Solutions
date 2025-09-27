public class MaximumDifference {
    private static class Solution {
        public int maxDifference(String s) {
            int[] freq = new int[26];
            for (char letter : s.toCharArray()) {
                freq[letter - 'a']++;
            }

            int minEven = s.length(), maxOdd = 0;
            for (int i = 0; i < 26; i++) {
                if (freq[i] == 0) continue;
                if (freq[i] % 2 == 0) {
                    minEven = Math.min(minEven, freq[i]);
                } else {
                    maxOdd = Math.max(maxOdd, freq[i]);
                }
            }

            return maxOdd - minEven;
        }
    }
}
