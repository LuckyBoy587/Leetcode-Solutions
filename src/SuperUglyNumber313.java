public class SuperUglyNumber313 {
    public static void main(String[] args) {
        int[] primes = {2, 7, 13, 19};
        System.out.println(new Solution().nthSuperUglyNumber(12, primes));
    }

    private static class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] index = new int[primes.length];
            long[] ugly = new long[n];
            long[] nextUgly = new long[primes.length];
            ugly[0] = 1;

            for (int i = 0; i < primes.length; i++) {
                nextUgly[i] = primes[i];
            }

            for (int i = 1; i < n; i++) {
                long minUgly = Long.MAX_VALUE;
                for (int j = 0; j < primes.length; j++) {
                    minUgly = Math.min(minUgly, nextUgly[j]);
                }

                ugly[i] = minUgly;

                for (int j = 0; j < nextUgly.length; j++) {
                    if (nextUgly[j] == minUgly) {
                        index[j]++;
                        nextUgly[j] = ugly[index[j]] * primes[j];
                    }
                }
            }

            return (int) ugly[n - 1];
        }
    }
}
