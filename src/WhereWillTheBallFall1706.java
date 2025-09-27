public class WhereWillTheBallFall1706 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1},
                {1, 1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1}
        };
        Solution solution = new Solution();
        int[] result = solution.findBall(grid);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static class Solution {
        public int[] findBall(int[][] grid) {
            if (grid[0].length == 1) return new int[]{-1};
            int[] result = new int[grid[0].length];
            for (int j = 0; j < grid[0].length; j++) {
                result[j] = find(grid, 0, j, grid[0][j]);
            }
            return result;
        }

        private int find(int[][] grid, int i, int j, int xDir) {
            if ((j == grid[0].length - 1 && xDir == 1) || (j == 0 && xDir == -1)) {
                return -1;
            }
            if (grid[i][j + xDir] != xDir) {
                return -1;
            }
            if (i == grid.length - 1) {
                return j + xDir;
            }

            int nextDir = grid[i + 1][j + xDir];
            return find(grid, i + 1, j + xDir, nextDir);
        }
    }
}
