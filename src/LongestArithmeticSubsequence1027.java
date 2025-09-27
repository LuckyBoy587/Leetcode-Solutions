import java.util.HashMap;

public class LongestArithmeticSubsequence1027 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));
    }

    private static class Solution {
        public int longestArithSeqLength(int[] nums) {
            int n = nums.length;
            HashMap<Integer, Integer>[] dp = new HashMap[n];
            int res = 1;
            for (int i = 0; i < n; i++) {
                dp[i] = new HashMap<>();
                for (int j = 0; j < i; j++) {
                    int diff = nums[i] - nums[j];
                    dp[i].merge(diff, dp[j].getOrDefault(diff, 1) + 1, Integer::max);
                    res = Math.max(res, dp[i].get(diff));
                }
            }

            return res;
        }
    }
}
