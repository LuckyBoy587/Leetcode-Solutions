import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumTimeToVisitCell2577 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 100, 1, 1, 1},
                {1, 100, 9, 100, 1},
                {1, 1, 1, 100, 1},
                {100, 100, 100, 100, 1},
                {100, 100, 100, 100, 1}
        };


        System.out.println(new Solution().minimumTime(grid));
    }
    private static class Solution {
        public int minimumTime(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            if (grid[1][0] > 1 && grid[0][1] > 1) return -1;
            int[][] minTime = new int[m][n];
            for (int[] row : minTime) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }

            minTime[0][0] = 0;
            int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(cell -> cell.time));
            pq.offer(new Cell(0, 0, 0));

            while (!pq.isEmpty()) {
                Cell curr = pq.poll();
                if (curr.i == m - 1 && curr.j == n - 1) {
                    return curr.time;
                }
                if (curr.time > minTime[curr.i][curr.j]) continue;
                for (int[] direction : directions) {
                    int ni = curr.i + direction[0];
                    int nj = curr.j + direction[1];

                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        int newTime = findNewTime(curr.time, grid[ni][nj]);
                        if (newTime < minTime[ni][nj]) {
                            minTime[ni][nj] = newTime;
                            pq.offer(new Cell(ni, nj, newTime));
                        }
                    }
                }

            }

            for (int[] row : minTime) {
                System.out.println(Arrays.toString(row));
            }

            return -1;
        }

        private int findNewTime(int currTime, int nextTime) {
            if (currTime + 1 >= nextTime) return currTime + 1;
            return nextTime + (currTime % 2 == nextTime % 2 ? 1: 0);
        }

        record Cell(int i, int j, int time) { }
    }
}
