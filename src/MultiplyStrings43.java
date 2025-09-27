public class MultiplyStrings43 {
    public static void main(String[] args) {
        System.out.println(new Solution().multiply("9", "9"));
    }
    private static class Solution {
        int n1, n2;
        public String multiply(String num1, String num2) {
            n1 = num1.length();
            n2 = num2.length();

            int[] result = new int[n1 + n2];
            int startIndex = n1 + n2 - 1;
            for (int i = n2 - 1; i >= 0; i--) {
                int currIndex = startIndex;
                int carry = 0;
                int multiplier = num2.charAt(i) - '0';
                for (int j = n1 - 1; j >= 0; j--) {
                    int val = (num1.charAt(j) - '0') * multiplier + result[currIndex] + carry;
                    carry = val / 10;
                    val %= 10;
                    result[currIndex--] = val;
                }

                if (carry != 0) {
                    result[currIndex] = carry;
                }

                startIndex--;
            }

            int i = 0;
            while (i < result.length && result[i] == 0) i++;
            if (i == result.length) return "0";
            StringBuilder sb = new StringBuilder();
            while (i < result.length) sb.append(result[i++]);
            return sb.toString();
        }
    }
}
