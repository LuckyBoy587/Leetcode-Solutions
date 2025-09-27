public class MinimumOperations2749 {
    private static class Solution {
        public int makeTheIntegerZero(int num1, int num2) {
            for (int res = 1; res < 60; res++) {
                long curr = (long) num1 - (long) res * num2;
                if (curr < 0) return -1;
                if (Long.bitCount(curr) <= res) return res;
            }
            return -1;
        }
    }
}
