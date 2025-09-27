public class MinimumOperationsToMakeArrayZero {
    private static class Solution {
        public long minOperations(int[][] queries) {
            long res = 0;
            for (int[] query : queries) {
                long curr = sumSequence(query[1]);
                if (query[0] > 0) curr -= sumSequence(query[0] - 1);
                res += (long) Math.ceil((double) curr / 2);
            }

            return res;
        }

        private long sumSequence(long n) {
            long m = (long) (Math.floor(Math.log(n) / Math.log(4)));
            long total = 0;

            for (long j = 0; j < m; j++) {
                total += 3 * (j + 1) * (long) Math.pow(4, j);
            }

            total += (m + 1) * (n - (long) Math.pow(4, m) + 1);
            return total;
        }
    }
}
