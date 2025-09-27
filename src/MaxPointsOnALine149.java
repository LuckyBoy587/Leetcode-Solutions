import java.util.HashMap;

public class MaxPointsOnALine149 {
    public static void main(String[] args) {
        int[][] twoDArray = {{1, 1}, {2, 2}, {3, 3}, {3, 0}};
        System.out.println(new Solution().maxPoints(twoDArray));
    }

    private static class Solution {
        public int maxPoints(int[][] points) {
            int res = 0;
            for (int i = 0; i < points.length; i++) {
                HashMap<String, Integer> map = new HashMap<>();
                for (int j = 0; j < points.length; j++) {
                    if (i == j) continue;
                    int dx = points[j][0] - points[i][0];
                    int dy = points[j][1] - points[i][1];
                    int gcd = gcd(dx, dy);
                    String slope = (dx / gcd) + "/" + (dy / gcd);
                    map.put(slope, map.getOrDefault(slope, 1) + 1);
                }

                for (int count: map.values()) {
                    res = Math.max(res, count);
                }
            }

            return res;
        }

        private int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }
}
