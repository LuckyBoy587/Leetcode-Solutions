public class NumberOfPointsInsideCircle1828 {
    private static class Solution {
        public int[] countPoints(int[][] points, int[][] queries) {
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                Circle circle = new Circle(queries[i][0], queries[i][1], queries[i][2]);
                for (int[] point : points) {
                    if (circle.contains(point[0], point[1])) {
                        res[i]++;
                    }
                }
            }
            return res;
        }

        static class Circle {
            int h, k, r;

            public Circle(int h, int k, int r) {
                this.h = h;
                this.k = k;
                this.r = r;
            }

            public boolean contains(int x, int y) {
                int dx = x - h;
                int dy = y - k;
                return dx * dx + dy * dy <= r * r;
            }
        }
    }
}
