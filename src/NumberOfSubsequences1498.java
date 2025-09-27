import java.util.Arrays;

public class NumberOfSubsequences1498 {
    public static void main(String[] args) {
        int[] nums = {3, 5, 6, 7};
        int target = 9;

        Solution solution = new Solution();
        int result = solution.numSubseq(nums, target);
        System.out.println("Number of subsequences: " + result);
    }

    private static class Solution {

        public static final int MOD = 1000000007;

        public int numSubseq(int[] nums, int target) {
            Arrays.sort(nums);
            long res = 0;
            int[] powersOf2 = computePowerOf2(nums.length);
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                if (nums[left] + nums[right] <= target) {
                    res = (res + powersOf2[right - left]) % MOD;
                    left++;
                } else {
                    right--;
                }
            }

            return (int) res;
        }

        private int[] computePowerOf2(int length) {
            int[] res = new int[length];
            res[0] = 1;
            for (int i = 1; i < length; i++) {
                res[i] = (res[i - 1] * 2) % MOD;
            }
            return res;
        }
    }
}
