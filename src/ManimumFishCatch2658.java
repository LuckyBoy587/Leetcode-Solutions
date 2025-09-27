public class ManimumFishCatch2658 {
    private static class Solution {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        public int findMaxFish(int[][] grid) {
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] > 0) {
                        res = Math.max(res, dfs(grid, i, j));
                    }
                }
            }

            return res;
        }

        private int dfs(int[][] grid, int row, int col) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
                return 0;
            }
            int res = grid[row][col];
            grid[row][col] = 0;
            for (int[] direction : directions) {
                res += dfs(grid, row + direction[0], col + direction[1]);
            }

            return res;
        }
    }
}
