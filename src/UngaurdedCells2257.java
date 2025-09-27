public class UngaurdedCells2257 {
    public static void main(String[] args) {
        int[][] guards = {{0, 0}, {1, 1}, {2, 3}};
        int[][] walls = {{0, 1}, {2, 2}, {1, 4}};

        System.out.println(new Solution().countUnguarded(4, 6, guards, walls));
    }
    private static class Solution {
        public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
            Cell[][] grid = new Cell[m][n];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = new Cell();
                }
            }

            for (int[] wallPoint: walls) {
                int x = wallPoint[0];
                int y = wallPoint[1];
                grid[x][y].isWall = true;
                grid[x][y].isGuarded = true;
            }

            for (int[] guard: guards) {
                int i = guard[0];
                int j = guard[1];
                grid[i][j].isWall = true;
                grid[i][j].isGuarded = true;

                for (int topI = i - 1; topI >= 0 && !grid[topI][j].isWall && !grid[topI][j].isVerticallyGuarded; topI--) {
                    grid[topI][j].isGuarded = true;
                    grid[topI][j].isVerticallyGuarded = true;
                }

                for (int topJ = j - 1; topJ >= 0 && !grid[i][topJ].isWall && !grid[i][topJ].isHorizontallyGuarded; topJ--) {
                    grid[i][topJ].isGuarded = true;
                    grid[i][topJ].isHorizontallyGuarded = true;
                }

                for (int bottomI = i + 1; bottomI < m && !grid[bottomI][j].isWall && !grid[bottomI][j].isVerticallyGuarded; bottomI++) {
                    grid[bottomI][j].isGuarded = true;
                    grid[bottomI][j].isVerticallyGuarded = true;
                }

                for (int bottomJ = j + 1; bottomJ < n && !grid[i][bottomJ].isWall && !grid[i][bottomJ].isHorizontallyGuarded; bottomJ++) {
                    grid[i][bottomJ].isGuarded = true;
                    grid[i][bottomJ].isHorizontallyGuarded = true;
                }
            }

            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!grid[i][j].isGuarded) {
                        count++;
                    }
                }
            }
            return count;
        }

        static class Cell {
            boolean isGuarded = false;
            boolean isWall = false;
            boolean isVerticallyGuarded = false;
            boolean isHorizontallyGuarded = false;

            @Override
            public String toString() {
                return isGuarded ? "False" : "True";
            }
        }
    }
}
