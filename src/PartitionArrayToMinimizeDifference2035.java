public class PartitionArrayToMinimizeDifference2035 {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumDifference(new int[]{3, 9, 7, 3}));
        System.out.println(new Solution().minimumDifference(new int[]{-36, 36}));
        System.out.println(new Solution().minimumDifference(new int[]{2, -1, 0, 4, -2, -9}));
    }

    private static class Solution {
        Integer[][] memo;

        public int minimumDifference(int[] nums) {
            int total = 0;
            for (int num : nums) total += Math.abs(num);
            memo = new Integer[nums.length][total + 1];
            return find(nums, 0, 0, 0, nums.length / 2, nums.length / 2);
        }

        private int find(int[] nums, int index, int pick, int skip, int pickCount, int skipCount) {
            if (pickCount < 0 || skipCount < 0) return Integer.MAX_VALUE;
            if (index == nums.length) return Math.abs(skip - pick);
            if (memo[index][Math.abs(pick - skip)] != null) {
                return memo[index][Math.abs(pick - skip)];
            }

            int res1 = find(nums, index + 1, pick + nums[index], skip, pickCount - 1, skipCount);
            int res2 = find(nums, index + 1, pick, skip + nums[index], pickCount, skipCount - 1);

            return memo[index][Math.abs(pick - skip)] = Math.min(res1, res2);
        }
    }

}
