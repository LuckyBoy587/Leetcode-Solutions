class RightTriangles3128 {
    private static class Solution {
        public long numberOfRightTriangles(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[] rowCount = new int[m];
            int[] colCount = new int[n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        rowCount[i]++;
                        colCount[j]++;
                    }
                }
            }

            long res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        res += (long) (rowCount[i] - 1) * (colCount[j] - 1);
                    }
                }
            }

            return res;
        }
    }
}