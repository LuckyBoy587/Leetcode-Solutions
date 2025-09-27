import java.util.*;

public class MinimumCostPath1368 {
    public static void main(String[] args) {
        int[][] twoDArray = {
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {1, 1, 1, 1},
                {2, 2, 2, 2}
        };
        System.out.println(new Solution().minCost(twoDArray));
    }

    private static class Solution {
        private final int[] directions = {0, 1, 0, -1, 0};
        private final int[] directionValues = {0, 1, 3, 2, 4};

        public int minCost(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dist = new int[m][n];
            for (int[] row : dist) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            dist[0][0] = 0;
            Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(val -> val[2]));
            queue.offer(new int[]{0, 0, 0}); // i, j

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int currI = curr[0];
                int currJ = curr[1];
                int currCost = curr[2];
                if (dist[currI][currJ] < currCost) {
                    continue;
                }
                int currDir = grid[currI][currJ];
                for (int x = 1; x <= 4; x++) {
                    int di = directions[x - 1];
                    int dj = directions[x];
                    int newI = currI + di;
                    int newJ = currJ + dj;
                    int nextDir = directionValues[x];
                    int newCost = currCost + (currDir != nextDir ? 1: 0);
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
                        if (newCost < dist[newI][newJ]) {
                            dist[newI][newJ] = newCost;
                            queue.offer(new int[]{newI, newJ, newCost});
                        }
                    }
                }
            }

            return dist[m - 1][n - 1];
        }
    }
}
