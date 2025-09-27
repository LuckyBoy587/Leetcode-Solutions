public class MaxFreqNumber3005 {
    private static class Solution {
        public int maxFrequencyElements(int[] nums) {
            int[] freq = new int[101];
            for (int num : nums) {
                freq[num]++;
            }

            int maxFreq = 0, total = 0;
            for (int freqVal : freq) {
                if (freqVal > maxFreq) {
                    maxFreq = freqVal;
                    total = 1;
                } else if (freqVal == maxFreq) {
                    total++;
                }
            }

            return maxFreq * total;
        }
    }
}
