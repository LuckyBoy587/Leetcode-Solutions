void main() {
    int[][] grid = {{0, 2}, {1, 3}};
    Solution solution = new Solution();
    IO.println("Result: " + solution.swimInWater(grid));
}

private static class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] minTime = new int[m][n];

        for (int[] row : minTime) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        minTime[0][0] = grid[0][0];
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.offer(new Cell(0, 0, grid[0][0]));
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            if (curr.i == m - 1 && curr.j == n - 1) break;

            for (int[] dir : dirs) {
                int ni = curr.i + dir[0], nj = curr.j + dir[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    int newTime = Math.max(curr.time, grid[ni][nj]);
                    if (newTime < minTime[ni][nj]) {
                        minTime[ni][nj] = newTime;
                        pq.offer(new Cell(ni, nj, newTime));
                    }
                }
            }
        }

        return minTime[m - 1][n - 1];
    }

    private static class Cell implements Comparable<Cell> {
        int i, j, time;

        public Cell(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }

        @Override
        public int compareTo(Cell o) {
            return this.time - o.time;
        }
    }
}
