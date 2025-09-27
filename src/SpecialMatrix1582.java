import java.util.Arrays;

public class SpecialMatrix1582 {
    private static class Solution {
        public int numSpecial(int[][] mat) {
            int[] rowSum = new int[mat.length];
            int[] colSum = new int[mat[0].length];

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    rowSum[i] += mat[i][j];
                    colSum[j] += mat[i][j];
                }
            }
            System.out.println(Arrays.toString(rowSum));
            System.out.println(Arrays.toString(colSum));
            int count = 0;
            for (int i = 0; i < rowSum.length; i++) {
                for (int j = 0; j < colSum.length; j++) {
                    if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
