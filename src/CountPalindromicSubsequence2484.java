public class CountPalindromicSubsequence2484 {
    public static void main(String[] args) {
        System.out.println(new Solution().countPalindromes("103301"));
    }
    private static class Solution {
        public int countPalindromes(String s) {
            int res = 0;
            for (char outerDigit = '0'; outerDigit <= '9'; outerDigit++) {
                int leftOuter = s.indexOf(outerDigit);
                int rightOuter = s.lastIndexOf(outerDigit);
                if (leftOuter == -1 || rightOuter == -1) {
                    continue;
                }
                String sub = s.substring(leftOuter + 1, rightOuter);
                for (char innerDigit = '0'; innerDigit <= '9'; innerDigit++) {
                    int leftInner = sub.indexOf(innerDigit);
                    int rightInner = sub.lastIndexOf(innerDigit);

                    if (leftInner == -1 || rightInner == -1) {
                        continue;
                    }
                    res += rightInner - leftInner - 1;
                }
            }

            return res;
        }
    }
}
