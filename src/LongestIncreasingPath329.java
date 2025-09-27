import java.util.Arrays;

public class LongestIncreasingPath329 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestIncreasingPath(new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        }));
    }

    private static class Solution {
        int[][] memo;
        int m, n;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int longestIncreasingPath(int[][] matrix) {
            int maxLen = 1;
            m = matrix.length;
            n = matrix[0].length;
            memo = new int[m][n];

            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    maxLen = Math.max(maxLen, get(matrix, i, j, 1));
                }
            }
            return maxLen;
        }

        public int get(int[][] arr, int i, int j, int currLen) {
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            int currMax = 0;
            for (int[] direction : directions) {
                int ni = i + direction[0];
                int nj = j + direction[1];
                if (ni < 0 || nj < 0 || ni == m || nj == n) continue;
                if (arr[i][j] < arr[ni][nj]) {
                    currMax = Math.max(currMax, 1 + get(arr, ni, nj, currLen + 1));
                }
            }

            return memo[i][j] = currMax;
        }
    }
}
