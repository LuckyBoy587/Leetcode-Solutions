public class DivisibilityCheck {
    private static class Solution {
        public boolean checkDivisibility(int n) {
            int sum = getSum(n);
            int product = getProduct(n);
            return n % (sum + product) == 0;
        }

        private int getSum(int num) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }

        private int getProduct(int num) {
            int product = 1;
            while (num > 0) {
                product *= num % 10;
                num /= 10;
            }

            return product;
        }
    }
}
