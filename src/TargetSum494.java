public class TargetSum494 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        System.out.println(new Solution().findTargetSumWays(arr, 3));
    }
    private static class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            return get(nums, 0, target, 0);
        }

        private int get(int[] nums, int index, int target, int currSum) {
            if (index == nums.length) {
                return currSum == target ? 1 : 0;
            }
            int pos = get(nums, index + 1, target, currSum + nums[index]);
            int neg = get(nums, index + 1, target, currSum - nums[index]);

            return pos + neg;
        }
    }
}
