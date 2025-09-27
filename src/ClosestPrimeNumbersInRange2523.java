public class ClosestPrimeNumbersInRange2523 {
    public static void main(String[] args) {
        new Solution().seiveOfRange(29, 37);
    }
    private static class Solution {
        public int[] closestPrimes(int left, int right) {
            int p1 = -1, p2 = -1, minDiff = Integer.MAX_VALUE;
            int prevPrime = -1;
            for (int i = Math.max(2, left); i <= right; i++) {
                if (isPrime(i)) {
                    if (prevPrime != -1 && i - prevPrime < minDiff) {
                        minDiff = i - prevPrime;
                        p1 = prevPrime;
                        p2 = i;

                        if (minDiff == 1) {
                            return new int[]{p1, p2};
                        }
                    }

                    prevPrime = i;
                }
            }

            return new int[]{p1, p2};
        }

        private boolean isPrime(int num) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        }

        public void seive(int num) {
            int limit = (num - 1) / 2;
            boolean[] visited = new boolean[limit + 1];
            for (int i = 1; i < limit; i++) {
                for (int j = 1; i + j + 2 * i * j <= limit; j++) {
                    visited[i + j + 2 * i * j] = true;
                }
            }

            for (int i = 1; i < limit; i++) {
                if (!visited[i]) {
                    System.out.println(2 * i + 1);
                }
            }
        }

        public void seiveOfRange(int left, int right) {
            int limit = (right + 1) / 2;
            boolean[] visited = new boolean[limit + 1];
            for (int i = 1; i < limit; i++) {
                for (int j = 1; i + j + 2 * i * j <= limit; j++) {
                    visited[i + j + 2 * i * j] = true;
                }
            }
            int start = Math.max(1, left / 2);
            for (int i = start; i < limit; i++) {
                if (!visited[i]) {
                    System.out.println(2 * i + 1);
                }
            }
        }
    }
}
