public class MinimumTimeToRepairCars2594 {
    private static class Solution {
        public long repairCars(int[] ranks, int cars) {
            long left = 1, right = Integer.MAX_VALUE, res = 0;
            int[] freq = new int[101];
            for (int rank: ranks) {
                right = Math.min(right, rank);
                freq[rank]++;
            }

            right *= (long) cars * cars;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (isPossible(freq, cars, mid)) {
                    res = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return res;
        }

        private boolean isPossible(int[] freq, int cars, long k) {
            long count = 0;
            for (int i = 0; i < freq.length; i++) {
                count += freq[i] * (long) Math.sqrt((double) k / i);
            }

            return count >= cars;
        }
    }
}
