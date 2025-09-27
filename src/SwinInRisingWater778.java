import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SwinInRisingWater778 {
    private static class Solution {
        public int swimInWater(int[][] grid) {
            int n = grid.length;
            int[][] dist = new int[n][n];
            for (int[] row : dist) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(cell -> dist[cell[0]][cell[1]]));
            pq.offer(new int[]{0, 0});
            dist[0][0] = grid[0][0];
            int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int currDist = dist[curr[0]][curr[1]];
                if (curr[0] == n - 1 && curr[1] == n - 1) return currDist;
                for (int[] dir : dirs) {
                    int ni = curr[0] + dir[0], nj = curr[1] + dir[1];
                    if (ni < 0 || nj < 0 || ni == n || nj == n) continue;
                    int nextDist = Math.max(currDist, grid[ni][nj]);
                    if (nextDist < dist[ni][nj]) {
                        dist[ni][nj] = nextDist;
                        pq.offer(new int[]{ni, nj});
                    }
                }
            }

            return -1;
        }
    }
}
