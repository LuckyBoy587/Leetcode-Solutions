public class SpecialSubstringOfLengthK {
    public static void main(String[] args) {
        System.out.println(new Solution().hasSpecialSubstring("aaaaad", 1));
    }
    private static class Solution {
        public boolean hasSpecialSubstring(String s, int k) {
            if (k == 1 && s.length() == 1) return true;
            int left = 0, right = 0;
            char[] letters = s.toCharArray();
            while (right < letters.length) {
                while (right < letters.length && letters[left] == letters[right] && right - left < k) {
                    right++;
                }
                if (right == letters.length) break;
                if (right - left == k) {
                    if ((left == 0 || letters[left] != letters[left - 1]) && (right == letters.length - 1 || letters[right] != letters[right + 1])) {
                        System.out.println(left + " " + right);
                        return true;
                    }
                }

                left = right = right + 1;
            }

            return false;
        }
    }
}
