public class AlternatingGroupsII3208 {
    private static class Solution {
        public int numberOfAlternatingGroups(int[] colors, int k) {
            int res = 0;
            int left = 0, right = 1;
            int n = colors.length;
            while (right < 2 * n && left < n) {
                if (colors[right % n] == colors[(right - 1) % n]) left = right;
                right++;
                if (right - left >= k) {
                    res++;
                    System.out.println(left + " " + right);
                }

            }
            return res;
        }
    }
}
