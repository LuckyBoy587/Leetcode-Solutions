public class CheckDigitsAreEqualQ1 {
    public static void main(String[] args) {
        System.out.println(new Solution().hasSameDigits("3902"));
        System.out.println(new Solution().hasSameDigits("34789"));
    }
    private static class Solution {
        public boolean hasSameDigits(String s) {
            while (s.length() > 2) {
                s = convert(s);
            }
            System.out.print(s + " ");
            return s.charAt(0) == s.charAt(1);
        }

        private String convert(String s) {
            StringBuilder sb = new StringBuilder();
            char prev = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                char cur = s.charAt(i);
                sb.append((prev - '0' + cur - '0') % 10);
                prev = cur;
            }
            return sb.toString();
        }
    }
}
