public class NumberOfSubstringWithAllThreeCharacters1358 {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSubstrings("abcabc"));
    }
    private static class Solution {
        int[] freq = new int[3];

        public int numberOfSubstrings(String s) {
            char[] letters = s.toCharArray();
            int left = 0, res = 0, extra = 0;
            for (int right = 0; right < letters.length; right++) {
                freq[letters[right] - 'a']++;

                while (left < right && hasAllLetters() && freq[letters[left] - 'a'] > 1) {
                    freq[letters[left++] - 'a']--;
                    extra++;
                }

                if (hasAllLetters()) {
                    res += extra + 1;
                }
            }

            return res;
        }

        private boolean hasAllLetters() {
            return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
        }
    }
}
