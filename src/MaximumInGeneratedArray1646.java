public class MaximumInGeneratedArray1646 {
    private static class Solution {
        public int getMaximumGenerated(int n) {
            if (n <= 1) return n;
            int[] nums = new int[n + 1];
            nums[0] = 0;
            nums[1] = 1;

            int i = 1;
            int res = 0;
            while (2 * i <= n) {
                nums[2 * i] = nums[i];
                res = Math.max(nums[2 * i], res);
                if (2 * i + 1 <= n) {
                    nums[2 * i + 1] = nums[i] + nums[i + 1];
                    res = Math.max(res, nums[2 * i + 1]);
                }
                i++;
            }
            return res;
        }
    }
}
