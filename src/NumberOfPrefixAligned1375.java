public class NumberOfPrefixAligned1375 {
    private static class Solution {
        public int numTimesAllBlue(int[] flips) {
            int res = 0;
            int maxSoFar = 0;
            for (int i = 0; i < flips.length; i++) {
                maxSoFar = Math.max(maxSoFar, flips[i]);
                if (maxSoFar == i) res++;
            }

            return res;
        }
    }
}
