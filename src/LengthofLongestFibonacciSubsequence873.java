import java.util.HashMap;

public class LengthofLongestFibonacciSubsequence873 {
    private static class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            HashMap<Integer, Integer> indexMap = new HashMap<>();
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                indexMap.put(arr[i], i);
            }

            int[][] dp = new int[n][n];
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int prev = arr[j] - arr[i];
                    if (prev < arr[i] && indexMap.containsKey(prev)) {
                        int k = indexMap.get(prev);
                        dp[i][j] = dp[k][i] + 1;
                        res = Math.max(res, dp[i][j]);
                    }
                }
            }
            return res == 0 ? 0 : res + 2;
        }
    }
}
