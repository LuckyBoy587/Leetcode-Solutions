import java.util.Arrays;

public class MinimumOperationsToMakeUniValueGrid2033 {
    private static class Solution {
        public int minOperations(int[][] grid, int x) {
            int mod = grid[0][0] % x;
            int[] arr = new int[grid.length * grid[0].length];
            int index = 0;
            for (int[] row : grid) {
                for (int val : row) {
                    arr[index++] = val;
                }
            }
            for (int val : arr) {
                if (val % x != mod) return -1;
            }
            Arrays.sort(arr);
            int mid = median(arr), res = 0;
            for (int[] row : grid) {
                for (int val : row) {
                    res += Math.abs(val - mid) / x;
                }
            }

            return res;
        }

        private int median(int[] arr) {
            return arr[arr.length / 2];
        }
    }
}
