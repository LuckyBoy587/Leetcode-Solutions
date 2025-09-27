public class SubmatrixWithAllOnes1504 {
    public static void main(String[] args) {
        int[][] testCase = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(new Solution().numSubmat(testCase));
    }

    private static class Solution {
        public int numSubmat(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int[][] heights = new int[m][n];
            System.arraycopy(mat[0], 0, heights[0], 0, n);

            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        heights[i][j] = heights[i - 1][j] + 1;
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int minHeight = Integer.MAX_VALUE;
                    for (int left = j; left >= 0 && minHeight > 0; left--) {
                        minHeight = Math.min(minHeight, heights[i][left]);
                        res += minHeight;
                    }
                }
            }

            return res;
        }
    }
}
