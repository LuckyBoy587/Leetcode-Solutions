import java.util.Arrays;

public class PartitionArrayToMinimizeXORQ3 {
    public static void main(String[] args) {
        int[] nums = {2,3,3,2};
        int k = 3;
        Solution solution = new Solution();
        int result = solution.minXor(nums, k);
        System.out.println("Minimum XOR value: " + result);
    }
    private static class Solution {
        public int minXor(int[] nums, int k) {
            int n = nums.length;
            int[] prefixXOR = new int[n + 1];
            for (int i = 0; i < n; i++) {
                prefixXOR[i + 1] = prefixXOR[i] ^ nums[i];
            }

            int[][] dp = new int[k + 1][n + 1];
            for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
            dp[0][0] = 0;

            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int x = 0; x < j; x++) {
                        int xor = prefixXOR[j] ^ prefixXOR[x];
                        if (dp[i - 1][x] != Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][x], xor));
                        }
                    }
                }
            }

            return dp[k][n];
        }
    }

}
