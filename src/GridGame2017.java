public class GridGame2017 {
    public static void main(String[] args) {
        int[][] arr = {{2, 5, 4}, {1, 5, 1}};
        System.out.println(new Solution().gridGame(arr));
    }
    private static class Solution {
        public long gridGame(int[][] grid) {
            int n = grid[0].length;
            long topSum = 0;
            for (int i = 0; i < n; i++) {
                topSum += grid[0][i];
            }

            int bottomSum = 0;
            long res = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                topSum -= grid[0][i];
                long currVal = Math.max(topSum, bottomSum);
                res = Math.min(res, currVal);
                bottomSum += grid[1][i];
            }
            return res;
        }
    }
}
