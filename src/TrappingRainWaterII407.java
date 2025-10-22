void main() {
    int[][] testCase = {
            {2, 3, 4},
            {5, 6, 7},
            {8, 9, 10},
            {11, 12, 13},
            {14, 15, 16}
    };
    Solution solution = new Solution();
    int result = solution.trapRainWater(testCase);
    System.out.println("Trapped water: " + result);
}

private static class Solution {
    int[][] minHeight;

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        minHeight = new int[m][n];
        for (int[] row : minHeight) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>();
        for (int i = 1; i < m - 1; i++) {
            addCell(pq, heightMap, i, 0);
            addCell(pq, heightMap, i, n - 1);
        }

        for (int j = 1; j < n - 1; j++) {
            addCell(pq, heightMap, 0, j);
            addCell(pq, heightMap, m - 1, j);
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            if (curr.height > minHeight[curr.i][curr.j]) {
                continue;
            }

            for (int[] direction : directions) {
                int ni = curr.i + direction[0];
                int nj = curr.j + direction[1];
                if (ni >=0 && ni < m && nj >= 0 && nj < n && heightMap[curr.i][curr.j] >= heightMap[ni][nj] && minHeight[ni][nj] > curr.height) {
                    minHeight[ni][nj] = curr.height;
                    pq.offer(new Cell(ni, nj, curr.height));
                }
            }
        }

        int totalWater = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (minHeight[i][j] != Integer.MAX_VALUE) {
                    totalWater += Math.max(0, minHeight[i][j] - heightMap[i][j]);
                }
            }
        }

        return totalWater;
    }

    private void addCell(PriorityQueue<Cell> pq, int[][] heightMap, int i, int j) {
        pq.offer(new Cell(i, j, heightMap[i][j]));
        minHeight[i][j] = heightMap[i][j];
    }

    private static class Cell implements Comparable<Cell> {
        int i, j, height;

        public Cell(int i, int j, int height) {
            this.i = i;
            this.j = j;
            this.height = height;
        }

        @Override
        public int compareTo(Cell o) {
            return this.height - o.height;
        }
    }
}