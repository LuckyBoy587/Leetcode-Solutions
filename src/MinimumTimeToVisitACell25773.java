import java.util.PriorityQueue;

public class MinimumTimeToVisitACell25773 {
    public static void main(String[] args) {
        int[][] myArray = {
                {0, 1, 3, 2},
                {5, 1, 2, 5},
                {4, 3, 8, 6}
        };
        System.out.println(new Solution().minimumTime(myArray));
    }
    private static class Solution {
        private int m, n;
        public int minimumTime(int[][] grid) {
            PriorityQueue<Cell> queue = new PriorityQueue<>();
            m = grid.length;
            n = grid[0].length;
            Cell startCell = new Cell(0, 0, 1);
            int[][] directions = {{0, 1}, {1, 0}};
            boolean[][] visited = new boolean[m][n];
            for (int[] direction : directions) {
                int ni = startCell.i + direction[0];
                int nj = startCell.j + direction[1];
                if (isNotOutOfBounds(ni, nj) && startCell.time >= grid[ni][nj]) {
                    queue.add(new Cell(ni, nj, startCell.time + 1));
                }
            }

            if (queue.isEmpty()) {
                return -1;
            }

            while (!queue.isEmpty()) {
                Cell curr = queue.poll();
                if (curr.i == m - 1 && curr.j == n - 1) {
                    return curr.time;
                }
                visited[curr.i][curr.j] = true;
                for (int[] direction : directions) {
                    int ni = curr.i + direction[0];
                    int nj = curr.j + direction[1];
                    if (isNotOutOfBounds(ni, nj) && !visited[ni][nj]) {
                        if (curr.time >= grid[ni][nj]) {
                            queue.add(new Cell(ni, nj, curr.time + 1));
                        } else {
                            queue.add(new Cell(ni, nj, (grid[ni][nj] + 1 - curr.time) / 2 + curr.time + 1));
                        }
                    }
                }
            }

            return -1;
        }

        private boolean isNotOutOfBounds(int ni, int nj) {
            return ni < m && ni >= 0 && nj < n && nj >= 0;
        }

        private static class Cell implements Comparable<Cell> {
            int i, j, time;
            Cell(int i, int j, int time) {
                this.i = i;
                this.j = j;
                this.time = time;
            }

            @Override
            public int compareTo(Cell o) {
                return Integer.compare(time, o.time);
            }
        }
    }
}
