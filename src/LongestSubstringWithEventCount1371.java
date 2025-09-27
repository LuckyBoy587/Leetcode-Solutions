import java.util.HashMap;

public class LongestSubstringWithEventCount1371 {
    public static void main(String[] args) {
        System.out.println(new Solution().findTheLongestSubstring("bcbcbc"));
    }

    private static class Solution {
        public int findTheLongestSubstring(String s) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int currMask = 0, res = 0;
            for (int i = 0; i < s.length(); i++) {
                int pos = charToIndex(s.charAt(i));
                if (pos != -1) {
                    currMask = toggleBit(currMask, pos);
                }
                if (!map.containsKey(currMask)) {
                    map.put(currMask, i);
                } else {
                    res = Math.max(res, i - map.get(currMask));
                }
            }

            return res;
        }

        private int toggleBit(int num, int pos) {
            return num ^ (1 << pos);
        }

        private int charToIndex(char letter) {
            return switch (letter) {
                case 'a' -> 0;
                case 'e' -> 1;
                case 'i' -> 2;
                case 'o' -> 3;
                case 'u' -> 4;
                default -> -1;
            };
        }
    }
}
