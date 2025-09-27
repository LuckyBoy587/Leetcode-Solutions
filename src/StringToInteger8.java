public class StringToInteger8 {
    private static class Solution {
        public int myAtoi(String s) {
            if (s.isEmpty()) return 0;
            s = s.strip();
            int sign = s.charAt(0) == '-' ? -1 : 1;
            int start = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;

            long sum = 0;
            while (start < s.length()) {
                if (!Character.isDigit(s.charAt(start))) break;
                sum *= 10;
                sum += s.charAt(start++) - '0';

                if (sum > Integer.MAX_VALUE) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }

            return (int) (sign * sum);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("   -042"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
