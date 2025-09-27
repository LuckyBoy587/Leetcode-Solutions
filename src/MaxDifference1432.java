public class MaxDifference1432 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxDiff(1101057));
    }
    private static class Solution {
        public int maxDiff(int num) {
            char[] numArr = String.valueOf(num).toCharArray();
            int max = 0, min = 0;
            char maxDigitToChange = getMaxDigitToChange(numArr);
            char minDigitToChange = getMinDigitToChange(numArr);

            for (char digit : numArr) {
                max *= 10;
                if (digit == maxDigitToChange) {
                    max += 9;
                } else {
                    max += digit - '0';
                }
            }

            int minChangeToDigit = numArr[0] == minDigitToChange ? 1 : 0;

            for (char digit : numArr) {
                min *= 10;
                if (digit == minDigitToChange) {
                    min += minChangeToDigit;
                } else {
                    min += digit - '0';
                }
            }

            return max - min;
        }

        private char getMaxDigitToChange(char[] numArr) {
            for (char digit : numArr) {
                if (digit != '9') {
                    return digit;
                }
            }

            return '*';
        }

        private char getMinDigitToChange(char[] numArr) {
            for (char digit : numArr) {
                if (digit > '1') {
                    return digit;
                }
            }

            return '*';
        }
    }
}
