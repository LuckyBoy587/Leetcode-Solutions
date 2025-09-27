public class CheckStraightLine1232 {
    private static class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            String slope = getSlope(coordinates[0], coordinates[1]);
            for (int i = 2; i < coordinates.length; i++) {
                if (!slope.equals(getSlope(coordinates[0], coordinates[i]))) {
                    return false;
                }
            }

            return true;
        }

        private String getSlope(int[] p1, int[] p2) {
            if (p1[0] == p2[0]) return "inf"; // vertical line
            if (p1[1] == p2[1]) return "0"; // horizontal line

            int dy = p2[1] - p1[1];
            int dx = p2[0] - p1[0];

            if (dx < 0) {
                dy = -dy;
                dx = -dx;
            }

            int gcd = gcd(dy, dx);
            return (dy / gcd) + "/" + (dx / gcd); // slope in reduced form
        }

        private int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }
}
