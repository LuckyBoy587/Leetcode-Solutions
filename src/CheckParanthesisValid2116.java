public class CheckParanthesisValid2116 {
    public static void main(String[] args) {
        System.out.println(new Solution().canBeValid(")(", "00"));
    }
    private static class Solution {
        public boolean canBeValid(String s, String locked) {
            if (s.length() % 2 != 0) return false;
            int minOpen = 0, maxOpen = 0;

            for (int i = 0; i < locked.length(); i++) {
                if (locked.charAt(i) == '0') {
                    minOpen--;
                    maxOpen++;
                } else if (s.charAt(i) == '(') {
                    minOpen++;
                    maxOpen++;
                } else {
                    minOpen--;
                    maxOpen--;
                }

                minOpen = Math.max(minOpen, 0);

                if (maxOpen < 0) return false;
            }

            return minOpen == 0;
        }
    }
}
