public class RangeBasedXOR1310 {
    private static class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int[] prefixXOR = new int[arr.length];
            prefixXOR[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                prefixXOR[i] = prefixXOR[i - 1] ^ arr[i];
            }

            int[] result = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                result[i] = prefixXOR[queries[i][1]];
                if (queries[i][0] > 0) {
                    result[i] ^= prefixXOR[queries[i][0] - 1];
                }
            }
            return result;
        }
    }
}
