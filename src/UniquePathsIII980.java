public class UniquePathsIII980 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        System.out.println(new Solution().uniquePathsIII(matrix));
    }
    private static class Solution {
        int m, n;

        public int uniquePathsIII(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            int emptySquareCount = 0;
            int startI = -1, startJ = -1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) emptySquareCount++;
                    else if (grid[i][j] == 1) {
                        startI = i;
                        startJ = j;
                    }
                }
            }
            return search(grid, startI, startJ, emptySquareCount + 1);
        }

        public int search(int[][] grid, int i, int j, int emptySquareCount) {
            if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) return 0;
            if (grid[i][j] == 2) {
                if (emptySquareCount == 0) {
                    return 1;
                }
                return 0;
            }
            grid[i][j] = -1;
            int res = search(grid, i + 1, j, emptySquareCount - 1) + search(grid, i - 1, j, emptySquareCount - 1) +
                    search(grid, i, j + 1, emptySquareCount - 1) + search(grid, i, j - 1, emptySquareCount - 1);
            grid[i][j] = 0;
            return res;
        }
    }
}
