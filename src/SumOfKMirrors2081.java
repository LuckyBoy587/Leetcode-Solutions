public class SumOfKMirrors2081 {
    public static void main(String[] args) {
        System.out.println(new Solution().kMirror(4, 5));
    }

    private static class Solution {
        public long kMirror(int k, int n) {
            long res = 0;
            for (long start = 1; n > 0; start *= 10) {
                for (long num = start; n > 0 && num < start * 10; num++) {
                    long palindrome = getPalindrome(num, true);
                    if (isPalindrome(palindrome, k)) {
                        res += palindrome;
                        n--;
                    }
                }

                for (long num = start; n > 0 && num < start * 10; num++) {
                    long palindrome = getPalindrome(num, false);
                    if (isPalindrome(palindrome, k)) {
                        res += palindrome;
                        n--;
                    }
                }
            }

            return res;
        }

        public long getPalindrome(long num, boolean skipLast) {
            long res = num;
            if (skipLast) num /= 10;
            while (num > 0) {
                res = res * 10 + num % 10;
                num /= 10;
            }
            return res;
        }

        public boolean isPalindrome(long num, int base) {
            String baseValue = Long.toString(num, base);
            int left = 0, right = baseValue.length() - 1;
            while (left < right) {
                if (baseValue.charAt(left) != baseValue.charAt(right)) return false;
                left++;
                right--;
            }
            return true;
        }
    }
}