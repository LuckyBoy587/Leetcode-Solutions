import java.util.Arrays;

public class MaximumDistanceQ4 {
    public static void main(String[] args) {
        int side = 9;
        int[][] points = {{8, 0}, {5, 9}, {2, 0}, {4, 9}, {0, 1}};
        int k = 4;
        System.out.println(new Solution().maxDistance(side, points, k));
    }

    private static class Solution {
        public int maxDistance(int side, int[][] points, int k) {
            int[] values = getValues(points, side);
            int res = 1;
            int left = 0, right = values[values.length - 1] - values[0];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (isPossibleDistance(values, mid, k)) {
                    left = mid + 1;
                    res = mid;
                } else {
                    right = mid - 1;
                }
            }

            return res;
        }

        private boolean isPossibleDistance(int[] values, int distance, int k) {
            int prev = values[0];
            for (int i = 1; i < values.length && k > 0; i++) {
                if (values[i] - prev >= distance) {
                    k--;
                    prev = values[i];
                }
            }
            return k == 0;
        }

        private int[] getValues(int[][] points, int side) {
            int n = points.length;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                int x = points[i][0];
                int y = points[i][1];

                if (y == 0) res[i] = x;
                else if (x == side) res[i] = y + side;
                else if (y == side) res[i] = side + side + (side - x);
                else res[i] = side + side + side + (side - y);
            }
            Arrays.sort(res);
            return res;
        }
    }
}
