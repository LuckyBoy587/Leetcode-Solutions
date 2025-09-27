public class MonotoneIncreasingDigits738 {
    public static void main(String[] args) {
        System.out.println(new Solution().monotoneIncreasingDigits(33332));
    }

    private static class Solution {
        public int monotoneIncreasingDigits(int n) {
            char[] num = String.valueOf(n).toCharArray();
            int breakIndex;
            for (breakIndex = 0; breakIndex < num.length - 1; breakIndex++) {
                if (num[breakIndex] > num[breakIndex + 1]) {
                    break;
                }
            }

            if (breakIndex == num.length - 1) {
                return n;
            }

            while (breakIndex > 0 && num[breakIndex] == num[breakIndex - 1]) {
                breakIndex--;
            }
            int step = (int) Math.pow(10, num.length - breakIndex - 1);
            int res = step - 1;
            num[breakIndex]--;
            while (breakIndex >= 0) {
                res = step * (num[breakIndex] - '0') + res;
                breakIndex--;
                step *= 10;
            }
            return res;
        }
    }
}
