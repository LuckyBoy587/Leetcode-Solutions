import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible1162 {
    private static class Solution {
        public int maxDistance(int[][] grid) {
            int n = grid.length;
            int[][] dist = new int[n][n];
            for (int[] row: dist) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        queue.offer(new int[]{i, j});
                        dist[i][j] = 0;
                    }
                }
            }

            if (queue.isEmpty() || queue.size() == n * n) return -1;
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                for (int[] dir: dirs) {
                    int ni = curr[0] + dir[0], nj = curr[1] + dir[1];
                    if (ni >= 0 && ni < n && nj >= 0 && nj < n && dist[curr[0]][curr[1]] + 1 < dist[ni][nj]) {
                        dist[ni][nj] = dist[curr[0]][curr[1]] + 1;
                        queue.offer(new int[]{ni, nj});
                    }
                }
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res = Math.max(res, dist[i][j]);
                }
            }
            return res;
        }
    }
}
