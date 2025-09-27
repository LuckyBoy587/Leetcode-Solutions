public class SubstringWithVowelAndKConsonentsII3306 {
    public static void main(String[] args) {
        System.out.println(new Solution().countOfSubstrings("ieaouqqieaouqq", 1));
        System.out.println(new Solution().countOfSubstrings("iqeaouqi", 2));
        System.out.println(new Solution().countOfSubstrings("buoeia", 0));
        System.out.println(new Solution().countOfSubstrings("aoaiuefi", 1));
    }

    private static class Solution {
        public long countOfSubstrings(String word, int k) {
            long res = 0;
            char[] letters = word.toCharArray();
            int[] freq = new int[26];
            int consonantCount = 0, left = 0, extra = 0;
            for (int right = 0; right < letters.length; right++) {
                char curr = letters[right];
                if (isVowel(curr)) {
                    freq[curr - 'a']++;
                } else {
                    consonantCount++;
                }

                while (consonantCount > k) {
                    if (isVowel(letters[left])) {
                        freq[letters[left] - 'a']--;
                    } else {
                        consonantCount--;
                    }
                    left++;
                    extra = 0;
                }

                while (hasAllVowels(freq) && consonantCount == k && left < right &&
                        freq[letters[left] - 'a'] > 1) {
                    extra++;
                    if (isVowel(letters[left])) freq[letters[left] - 'a']--;
                    else consonantCount--;
                    left++;
                }

                if (hasAllVowels(freq) && consonantCount == k) {
                    res += extra + 1;
                }
            }

            return res;
        }

        private boolean hasAllVowels(int[] freq) {
            return freq[0] > 0 && freq['e' - 'a'] > 0 && freq['i' - 'a'] > 0 && freq['o' - 'a'] > 0 && freq['u' - 'a'] > 0;
        }

        private boolean isVowel(char letter) {
            return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
        }
    }
}
