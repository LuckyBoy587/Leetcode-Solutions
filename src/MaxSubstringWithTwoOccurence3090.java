public class MaxSubstringWithTwoOccurence3090 {
    private static class Solution {
        public int maximumLengthSubstring(String s) {
            int[] freq = new int[26];
            int left = 0, right = 0;
            int maxLen = 0;

            while (right < s.length()) {
                while (right < s.length() && freq[s.charAt(right) - 'a'] < 2) {
                    freq[s.charAt(right) - 'a']++;
                    right++;
                }

                if (right == s.length()) break;

                maxLen = Math.max(maxLen, right - left);
                while (freq[s.charAt(right) - 'a'] == 2) {
                    freq[s.charAt(left) - 'a']--;
                    left++;
                }
            }

            return Math.max(maxLen, right - left);
        }
    }
}
