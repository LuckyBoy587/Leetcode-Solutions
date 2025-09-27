public class BasicCalculator224 {
    private static class Solution {
        int index = 0;
        public int calculate(String s) {
            int res = 0;
            int num = 0, sign = 1;

            while (index < s.length()) {
                char letter = s.charAt(index++);
                if (letter == ' ') continue;
                if (letter == '(') {
                    num = calculate(s);
                } else if (letter == ')') {
                    res += sign * num;
                    return res;
                }
                else if (Character.isDigit(letter)) {
                    num = num * 10 + (letter - '0');
                }  else {
                    res += sign * num;
                    num = 0;
                    sign = letter == '+' ? 1 : -1;
                }
            }

            return res + sign * num;
        }
    }
}
