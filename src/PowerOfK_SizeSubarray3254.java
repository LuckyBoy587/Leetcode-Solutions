import java.util.Arrays;

public class PowerOfK_SizeSubarray3254 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3)));
    }
    private static class Solution {
        public int[] resultsArray(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];
            res[0] = nums[0];
            int consecutiveCount = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] + 1 == nums[i]) {
                    consecutiveCount++;
                } else {
                    consecutiveCount = 1;
                }
                if (i >= k - 1) {
                    res[i - k + 1] = consecutiveCount >= k ? nums[i] : -1;
                }
            }

            return res;
        }
    }
}
