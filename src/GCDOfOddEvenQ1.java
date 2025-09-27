public class GCDOfOddEvenQ1 {
    private static class Solution {
        public int gcdOfOddEvenSums(int n) {
            int odd = 0, even = 0;
            for (int i = 0; i < n; i++) {
                odd += 2 * i + 1;
                even += 2 * i + 2;
            }

            return GCD(odd, even);
        }

        private int GCD(int a, int b) {
            if (b == 0) return a;
            return GCD(b, a % b);
        }
    }
}
