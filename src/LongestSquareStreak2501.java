import java.util.Arrays;

public class LongestSquareStreak2501 {
    public static void main(String[] args) {
        int[] numbers = {4,16,256,65536};
        System.out.println(new Solution().longestSquareStreak(numbers));
    }

    private static class Solution {
        public int longestSquareStreak(int[] nums) {
            Arrays.sort(nums);
            int[] dp = new int[nums[nums.length - 1] + 1];
            for (int num : nums) {
                if (isSquareNumber(num)) {
                    dp[num] = dp[getSqrt(num)] + 1;
                } else {
                    dp[num] = 1;
                }
            }
            int res = -1;
            for (int val : dp) {
                res = Math.max(res, val);
            }
            System.out.println(Arrays.toString(dp));
            return res == 1 ? -1 : res;
        }

        private boolean isSquareNumber(int num) {
            if (num <= 1) return false;
            double sqrt = Math.sqrt(num);
            return Math.ceil(sqrt) == Math.floor(sqrt);
        }

        private int getSqrt(int num) {
            return (int) Math.sqrt(num);
        }
    }
}
