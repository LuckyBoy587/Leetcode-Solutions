public class CountSquareSubmatrix1277 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 1, 0, 1, 1},
                {1, 0, 0, 1, 1}
        };
        System.out.println(new Solution().countSquares(matrix));
    }

    private static class Solution {
        public int countSquares(int[][] matrix) {
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 1) {
                        matrix[i][j] += Integer.min(matrix[i - 1][j - 1], Integer.min(matrix[i - 1][j], matrix[i][j - 1]));
                    }
                }
            }
            int res = 0;
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    res += anInt;
                }
            }
            return res;
        }
    }
}
