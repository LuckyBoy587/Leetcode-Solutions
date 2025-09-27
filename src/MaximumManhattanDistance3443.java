public class MaximumManhattanDistance3443 {
    private static class Solution {
        public int maxDistance(String s, int k) {
            int verticalDistance = 0, horizontalDistance = 0;
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case 'W':
                        horizontalDistance--;
                        break;
                    case 'E':
                        horizontalDistance++;
                        break;
                    case 'S':
                        verticalDistance++;
                        break;
                    case 'N':
                        verticalDistance--;
                }

                int manhattanDistance = Math.abs(horizontalDistance) + Math.abs(verticalDistance);
                res = Math.max(res, Math.min(manhattanDistance + k * 2, i + 1));
            }

            return res;
        }
    }
}
