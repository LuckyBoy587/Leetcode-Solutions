public class MaximumPositiveNegativeCount2529 {
    private static class Solution {
        public int maximumCount(int[] nums) {
            int left = findLeftIndex(nums) + 1;
            int right = nums.length - findRightIndex(nums);

            return Math.max(left, right);
        }

        private int findRightIndex(int[] nums) {
            int left = 0, right = nums.length - 1;
            int res = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > 0) {
                    res = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return res;
        }

        private int findLeftIndex(int[] nums) {
            int left = 0, right = nums.length - 1;
            int res = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < 0) {
                    res = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return res;
        }
    }
}
