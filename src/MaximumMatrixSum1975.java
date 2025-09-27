public class MaximumMatrixSum1975 {
    public static void main(String[] args) {
        int[][] matrix = {
                {-1, 0, -1},
                {-2, 1, 3},
                {3, 2, 2}
        };
        System.out.println(new Solution().maxMatrixSum(matrix));
    }
    private static class Solution {
        public long maxMatrixSum(int[][] matrix) {
            int n = matrix[0].length;

            boolean isOddNegative = false;
            int leastNegative = Integer.MAX_VALUE;
            long sum = 0;
            for (int[] row : matrix) {
                for (int j = 0; j < n; j++) {
                    if (row[j] < 0) {
                        isOddNegative = !isOddNegative;
                        row[j] = -row[j];
                    }

                    sum += row[j];
                    leastNegative = Math.min(leastNegative, row[j]);
                }
            }

            if (isOddNegative) {
                sum -= leastNegative * 2L;
            }
            return sum;
        }
    }
}
