public class CommonPrefixArray2657 {
    private static class Solution {
        public int[] findThePrefixCommonArray(int[] A, int[] B) {
            int n = A.length;
            boolean[] visitedA = new boolean[n + 1];
            boolean[] visitedB = new boolean[n + 1];

            int[] res = new int[A.length];
            for (int i = 0; i < A.length; i++) {
                visitedA[A[i]] = true;
                visitedB[B[i]] = true;

                for (int j = 0; j <= n; j++) {
                    if (visitedA[j] && visitedB[j]) {
                        res[i]++;
                    }
                }
            }

            return res;
        }
    }
}
