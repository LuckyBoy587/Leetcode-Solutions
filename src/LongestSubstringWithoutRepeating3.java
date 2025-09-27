public class LongestSubstringWithoutRepeating3 {
    public static void main(String[] args) {
        String word = "tmmzuxt";
        System.out.println(new Solution().lengthOfLongestSubstring(word));
    }

    private static class Solution {
        public int lengthOfLongestSubstring(String s) {
            boolean[] visited = new boolean[123];
            int res = 0;
            int left = 0, right = 0;

            while (right < s.length()) {
                while (right < s.length() && !visited[s.charAt(right)]) {
                    visited[s.charAt(right)] = true;
                    right++;
                }

                res = Math.max(res, right - left);
                if (right == s.length()) break;
                while (left < right && s.charAt(left) != s.charAt(right)) {
                    visited[s.charAt(left++)] = false;
                }
                visited[s.charAt(left++)] = false;
            }

            return res;
        }
    }
}
