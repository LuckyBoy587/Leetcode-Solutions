public class CheckNumberIsSumOfPowerOfThree1780 {
    public static void main(String[] args) {
        System.out.println(new Solution().checkPowersOfThree(94));
    }
    private static class Solution {
        public boolean checkPowersOfThree(int n) {
            System.out.println(Integer.toString(n, 3));
            int div = 1;
            while (div * 3 <= n) div *= 3;
            while (n > 0 && div > 0) {
                System.out.println(div + " " + n);
                n -= div;
                do {
                    div /= 3;
                } while (div > n);
            }
            return n == 0;
        }
    }
}
