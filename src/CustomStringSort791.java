public class CustomStringSort791 {
    private static class Solution {
        public String customSortString(String order, String s) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < order.length(); i++) {
                while (freq[order.charAt(i) - 'a']-- > 0) {
                    sb.append(order.charAt(i));
                }
            }

            for (int i = 0; i < s.length(); i++) {
                while (freq[s.charAt(i) - 'a']-- > 0) {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }
}
