public class CountUnique3LengthPalindrome1930 {
    public static void main(String[] args) {
        System.out.println(new Solution().countPalindromicSubsequence("bbcbaba"));
    }

    private static class Solution {
        public int countPalindromicSubsequence(String s) {
            int res = 0;
            for (char letter = 'a'; letter <= 'z'; letter++) {
                int i = s.indexOf(letter);
                int j = s.lastIndexOf(letter);

                boolean[] currLetters = new boolean[26];
                for (int x = i + 1; x < j; x++) {
                    int currLetter = s.charAt(x) - 'a';
                    if (!currLetters[currLetter]) {
                        currLetters[currLetter] = true;
                        res++;
                    }
                }
            }
            return res;
        }
    }
}
