import java.util.*;

public class LongestSubsequenceRepeatedKTimes2014 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestSubsequenceRepeatedK("letsleetcode", 2));
    }
    public static class Solution {
        public String longestSubsequenceRepeatedK(String s, int k) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            List<Character> possibleChars = new ArrayList<>();
            for (char letter = 'a'; letter <= 'z'; letter++) {
                if (freq[letter - 'a'] >= k) {
                    possibleChars.add(letter);
                }
            }
            possibleChars.sort(Collections.reverseOrder());

            String res = "";
            int maxLen = s.length() / k;
            Queue<String> queue = new LinkedList<>();
            queue.offer(res);

            while (!queue.isEmpty()) {
                String curr = queue.poll();
                for (char validChar : possibleChars) {
                    String newStr = curr + validChar;
                    if (newStr.length() > maxLen) continue;
                    if (isSubsequence(s, newStr.repeat(k))) {
                        if (newStr.length() > res.length()) res = newStr;
                        else if (newStr.length() == res.length() && newStr.compareTo(res) > 0) res = newStr;
                        queue.offer(newStr);
                    }
                }
            }
            return res;
        }

        private boolean isSubsequence(String s, String t) {
            int j = 0;
            for (int i = 0; i < s.length() && j < t.length(); i++) {
                if (s.charAt(i) == t.charAt(j)) j++;
            }

            return j == t.length();
        }
    }
}
