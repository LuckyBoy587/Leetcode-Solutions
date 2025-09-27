public class MaxDifferenceByRemappingDigits2566 {
    public static void main(String[] args) {
        System.out.println(new Solution().minMaxDifference(11891));
    }
    private static class Solution {
        public int minMaxDifference(int num) {
            char[] digits = String.valueOf(num).toCharArray();
            int maxNum = 0, minNum = 0;
            char maxSwap = getMaxSwapDigit(digits);
            char minSwap = digits[0];

            for (char letter : digits) {
                maxNum *= 10;
                maxNum += letter == maxSwap ? 9: letter - '0';

                minNum *= 10;
                minNum += letter == minSwap ? 0: letter - '0';
            }

            return maxNum - minNum;
        }

        private char getMaxSwapDigit(char[] digits) {
            for (char digit : digits) {
                if (digit != '9') {
                    return digit;
                }
            }
            return '9';
        }
    }
}
