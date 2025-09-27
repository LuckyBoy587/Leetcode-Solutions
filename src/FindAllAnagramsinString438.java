import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsinString438 {

    private static class Solution {
        /**
         * Finds all the starting indices of the anagrams of the string `p` within the string `s`.
         *
         * This method identifies substrings in `s` that are anagrams of `p` and returns their starting indices
         * in ascending order. An anagram of `p` is a permutation of its characters. If no such substrings exist
         * or if `s` is shorter than `p`, an empty list is returned.
         *
         * The function uses a sliding window approach to efficiently traverse the string `s` and compare character
         * frequencies with the target string `p`.
         *
         * @param s The input string in which to find anagrams of `p`. Must consist of lowercase English letters only.
         * @param p The target string whose anagrams are to be located in `s`. Must consist of lowercase English letters only.
         * @return A list of integers representing the starting indices of each anagram of `p` found in `s`.
         */
        public List<Integer> findAnagrams(String s, String p) {
            if (s.length() < p.length()) return new ArrayList<>();
            int[] targetArr = getFreq(p);
            int[] currArr = getFreq(s.substring(0, p.length() - 1));
            List<Integer> res = new ArrayList<>();

            for (int i = p.length() - 1; i < s.length(); i++) {
                currArr[s.charAt(i) - 'a']++;
                if (Arrays.equals(currArr, targetArr)) {
                    res.add(i - p.length() + 1);
                }
                currArr[s.charAt(i - p.length() + 1) - 'a']--;
            }

            return res;
        }

        private int[] getFreq(String s) {
            int[] freq = new int[26];
            for (char letter : s.toCharArray()) {
                freq[letter - 'a']++;
            }

            return freq;
        }
    }
}