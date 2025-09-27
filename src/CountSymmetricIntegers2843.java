public class CountSymmetricIntegers2843 {
    public static void main(String[] args) {
        System.out.println(new Solution().countSymmetricIntegers(135, 2025));
        System.out.println(new Solution().countSymmetricIntegers(1, 100));
        System.out.println(new Solution().countSymmetricIntegers(1200, 1230));
    }
    private static class Solution {
        public int countSymmetricIntegers(int low, int high) {
            int count = 0;
            for (int num = low; num <= high; num++) {
                int digits = digitCount(num);
                if (digits % 2 != 0) {
                    num = (int) Math.pow(10, digits);
                } else if (isSymmetric(num, digits)) {
//                    System.out.print(num + " ");
                    count++;
                }
            }
            return count;
        }

        private int digitCount(int num) {
            return (int) Math.floor(Math.log10(num)) + 1;
        }

        private boolean isSymmetric(int num, int digits) {
            int sum = 0;
            for (int i = 0; num > 0; i++) {
                sum += (num % 10) * (i < digits / 2 ? 1: -1);
                num /= 10;
            }
            return sum == 0;
        }
    }
}
