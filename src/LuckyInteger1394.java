public class LuckyInteger1394 {
    private static class Solution {
        public int findLucky(int[] arr) {
            int maxFreq = 0;
            int[] freq = new int[501];
            for (int num: arr) {
                freq[num]++;
                maxFreq = Math.max(maxFreq, freq[num]);
            }

            for (int num = maxFreq; num >= 1; num--) {
                if (freq[num] == num) {
                    return num;
                }
            }

            return -1;
        }
    }
}
