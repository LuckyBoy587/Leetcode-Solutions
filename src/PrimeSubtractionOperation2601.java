public class PrimeSubtractionOperation2601 {
    public static void main(String[] args) {
        System.out.println(new Solution().primeSubOperation(new int[]{4, 9, 6, 10}));
    }

    private static class Solution {
        boolean[] prime = new boolean[1001];

        public boolean primeSubOperation(int[] nums) {
            for (int i = 2; i < 1001; i++) {
                prime[i] = isPrime(i);
            }
            for (int i = 0; i < nums.length - 1; i++) {
                int curr = nums[i];
                for (int num = curr - 1; num >= 2; num--) {
                    if (isPrime(num)) {
                        if (i == 0 || curr - num > nums[i - 1]) {
                            nums[i] -= num;
                            break;
                        }
                    }
                }
                if (nums[i] >= nums[i + 1]) return false;
            }
            return true;
        }

        private boolean isPrime(int num) {
            if (num < 2) return false;
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }
}
