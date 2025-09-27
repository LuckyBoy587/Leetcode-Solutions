public class KMatchingAdjacentElement3405 {
    private static class Solution {
        private int MOD = 1000000007;
        public int countGoodArrays(int n, int m, int k) {
            long comb = combination(n - 1, k);
            long blockValues = (long) (m * Math.pow(m - 1, n - k - 1));

            return (int) ((comb * blockValues) % MOD);
        }

        private long combination(int n, int r) {
            long nFact = fact(n);
            long rFact = fact(r);
            long diffFact = fact(n - r);

            return nFact / (rFact * diffFact);
        }

        private long fact(long num) {
            if (num <= 1) return 1;
            return num * fact(num - 1);
        }
    }
}
