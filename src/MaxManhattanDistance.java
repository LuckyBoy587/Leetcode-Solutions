public class MaxManhattanDistance {
    public static void main(String[] args) {
        System.out.println(new Solution().maxDistance("NWSE", 1));
    }
    private static class Solution {
        public int maxDistance(String s, int k) {
            int x = 0, y = 0, maxDistance = 0;

            for (char c : s.toCharArray()) {
                if (c == 'N') y++;
                else if (c == 'S') y--;
                else if (c == 'E') x++;
                else if (c == 'W') x--;

                maxDistance = Math.max(maxDistance, Math.abs(x) + Math.abs(y));
            }

            return maxDistance + Math.min(k, s.length());
        }
    }
}
