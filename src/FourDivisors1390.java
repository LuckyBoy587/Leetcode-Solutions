public class FourDivisors1390 {
    public static void main(String[] args) {
        System.out.println(new Solution().sumFourDivisors(new int[]{8}));
    }
    private static class Solution {
        public int sumFourDivisors(int[] nums) {
            int res = 0;
            for (int num : nums) {
                int nextFactor = getSmallestFactor(num);
                int largestFactor = num / nextFactor;

                if (largestFactor == nextFactor) continue;
                if (isNotPrime(nextFactor)) continue;
                if (isNotPrime(largestFactor) && nextFactor * nextFactor != largestFactor) continue;
                res += largestFactor + nextFactor + num + 1;
            }
            return res;
        }

        private int getLargestFactor(int num) {
            for (int div = num / 2; div > 1; div--) {
                if (num % div == 0) {
                    return div;
                }
            }
            return 1;
        }

        private int getSmallestFactor(int num) {
            for (int div = 2; div < num; div++) {
                if (num % div == 0) {
                    return div;
                }
            }
            return num;
        }

        private boolean isNotPrime(int num) {
            if (num < 2) {
                return true;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return true;
                }
            }
            return false;
        }
    }
}
