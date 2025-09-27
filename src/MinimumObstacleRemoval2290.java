import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumObstacleRemoval2290 {
    private static class Solution {
        public int minimumObstacles(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dist = new int[m][n];
            boolean[][] visited = new boolean[m][n];
            for (int[] row : dist) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            PriorityQueue<Cell> pq = new PriorityQueue<>();
            pq.offer(new Cell(0, 0, 0));
            while (!pq.isEmpty()) {
                Cell curr = pq.poll();
                if (curr.i + 1 == m && curr.j + 1 == n) {
                    return curr.weight;
                }
                if (!visited[curr.i][curr.j]) {
                    visited[curr.i][curr.j] = true;
                    dist[curr.i][curr.j] = curr.weight;
                    if (curr.i > 0 && dist[curr.i - 1][curr.j] > curr.weight + grid[curr.i - 1][curr.j]) {
                        pq.offer(new Cell(curr.i - 1, curr.j, curr.weight + grid[curr.i - 1][curr.j]));
                    }
                    if (curr.j > 0 && dist[curr.i][curr.j - 1] > curr.weight + grid[curr.i][curr.j - 1]) {
                        pq.offer(new Cell(curr.i,  curr.j - 1, curr.weight + grid[curr.i][curr.j - 1]));
                    }

                    if (curr.i + 1 < m && dist[curr.i + 1][curr.j] > curr.weight + grid[curr.i + 1][curr.j]) {
                        pq.offer(new Cell(curr.i + 1, curr.j, curr.weight + grid[curr.i + 1][curr.j]));
                    }

                    if (curr.j + 1 < n && dist[curr.i][curr.j + 1] > curr.weight + grid[curr.i][curr.j + 1]) {
                        pq.offer(new Cell(curr.i,  curr.j + 1, curr.weight + grid[curr.i][curr.j + 1]));
                    }
                }
            }
            return -1;
        }

        static class Cell implements Comparable<Cell> {

            int i, j, weight;
            public Cell(int i, int j, int weight) {
                this.i = i;
                this.j = j;
                this.weight = weight;
            }

            @Override
            public int compareTo(Cell o) {
                return Integer.compare(weight, o.weight);
            }
        }
    }
}
