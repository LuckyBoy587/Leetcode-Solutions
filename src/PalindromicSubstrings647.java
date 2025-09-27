public class PalindromicSubstrings647 {
    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("abba"));
        System.out.println(new Solution().countSubstrings("abc"));
        System.out.println(new Solution().countSubstrings("aaa"));
        System.out.println(new Solution().countSubstrings("aba"));
        System.out.println(new Solution().countSubstrings("aaaaa"));
    }
    private static class Solution {
        public int countSubstrings(String s) {
            char[] letters = s.toCharArray();
            int res = 0;

            for (int i = 0; i < letters.length; i++) {
                res += count(letters, i, i);
                res += count(letters, i, i + 1);
            }

            return res;
        }

        private int count(char[] letters, int left, int right) {
            int res = 0;
            while (left >= 0 && right < letters.length && letters[right] == letters[left]) {
                left--;
                right++;
                res++;
            }
            return res;
        }
    }
}
