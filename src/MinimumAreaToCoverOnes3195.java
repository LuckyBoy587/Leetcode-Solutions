public class MinimumAreaToCoverOnes3195 {
    public static void main(String[] args) {
        int[][] array = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        System.out.println(new Solution().minimumArea(array));
    }

    private static class Solution {
        public int minimumArea(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int startI = m, startJ = n, endI = -1, endJ = -1;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        startI = Math.min(startI, i);
                        startJ = Math.min(startJ, j);
                        endI = Math.max(endI, i);
                        endJ = Math.max(endJ, j);
                    }
                }
            }


            int width = endI - startI + 1;
            int height = endJ - startJ + 1;
            return width * height;
        }
    }
}
