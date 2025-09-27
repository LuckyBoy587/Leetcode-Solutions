import java.util.List;

public class TotalCharactersInStringAfterTransformationII3337 {
    private static class Solution {
        private final int MOD = 1000000007;
        private final int SIZE = 26;

        public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
            long[][] matrix = new long[SIZE][SIZE];
            for (int start = 0; start < SIZE; start++) {
                for (int step = 1; step <= nums.get(start); step++) {
                    int dest = (start + step) % SIZE;
                    matrix[start][dest] = 1;
                }
            }

            long[][] transformationMatrix = power(matrix, t);
            int[] freq = new int[SIZE];
            for (char c: s.toCharArray()) {
                freq[c - 'a']++;
            }

            long total = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    total = (total + transformationMatrix[i][j]) % MOD;
                }
            }

            return (int) total;
        }


        public long[][] multiply(long[][] A, long[][] B) {
            long[][] result = new long[SIZE][SIZE];

            for (int i = 0; i < SIZE; i++) {
                for (int k = 0; k < SIZE; k++) {
                    if (A[i][k] == 0) continue;
                    for (int j = 0; j < SIZE; j++) {
                        result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % MOD;
                    }
                }
            }

            return result;
        }

        public long[][] power(long[][] matrix, int exponent) {
            long[][] result = new long[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                result[i][i] = 1;
            }

            while (exponent > 0) {
                if ((exponent & 1) == 1) {
                    result = multiply(result, matrix);
                }
                matrix = multiply(matrix, matrix);
                exponent >>= 1;
            }

            return result;
        }

    }
}
