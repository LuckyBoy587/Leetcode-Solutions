import java.util.HashMap;

public class MaximumWindowSubstring76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution solution = new Solution();
        System.out.println(solution.minWindow(s, t));
    }

    private static class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : t.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            int resStart = 0, resEnd = 2 * s.length();
            int left = 0, right = 0;
            HashMap<Character, Integer> windowMap = new HashMap<>();
            while (right < s.length()) {
                while (right < s.length() && !isWindowEnough(windowMap, map)) {
                    windowMap.merge(s.charAt(right++), 1, Integer::sum);
                }
                if (!isWindowEnough(windowMap, map)) break;
                while (isWindowEnough(windowMap, map)) {
                    windowMap.merge(s.charAt(left++), -1, Integer::sum);
                }
                if ((right - left + 1) < (resEnd - resStart)) {
                    resStart = left - 1;
                    resEnd = right;
                }
            }

            return resEnd == 2 * s.length() ? "" : s.substring(resStart, resEnd);
        }

        private boolean isWindowEnough(HashMap<Character, Integer> windowMap, HashMap<Character, Integer> map) {
            for (char c : map.keySet()) {
                if (windowMap.getOrDefault(c, 0) < map.get(c)) {
                    return false;
                }
            }

            return true;
        }
    }
}
