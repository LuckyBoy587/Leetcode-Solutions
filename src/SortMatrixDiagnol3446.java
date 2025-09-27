import java.util.Arrays;

public class SortMatrixDiagnol3446 {
    private static class Solution {
        public int[][] sortMatrix(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                sortDiagonal(grid, i, 0, false);
            }

            for (int j = 1; j < grid.length; j++) {
                sortDiagonal(grid, 0, j, true);
            }

            return grid;
        }

        private void sortDiagonal(int[][] grid, int i, int j, boolean isAscending) {
            int n = grid.length;
            int len = Math.min(n - i, n - j);
            Integer[] newArr = new Integer[len];
            for (int step = 0; step < len; step++) {
                newArr[step] = grid[i + step][j + step];
            }

            Arrays.sort(newArr, isAscending ? Integer::compareTo : (a, b) -> b - a);
            for (int step = 0; step < len; step++) {
                grid[i + step][j + step] = newArr[step];
            }
        }
    }
}
