public class LongestSpecialString2982 {
    private static class Solution {
        public int maximumLength(String s) {
            int st = 1, end = s.length() - 1;
            int res = -1;
            while (st <= end) {
                int k = st + (end - st) / 2;
                if (check(s, k)) {
                    res = k;
                    st = k + 1;
                } else {
                    end = k - 1;
                }
            }
            return res;
        }

        private boolean check(String word, int k) {
            int[] freq = new int[26];
            int st = 0;
            for (int end = 0; end < word.length(); end++) {
                if (word.charAt(end) != word.charAt(st)) {
                    st = end;
                } else if (end - st + 1 == k) {
                    if (++freq[word.charAt(st++) - 'a'] == 3) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
