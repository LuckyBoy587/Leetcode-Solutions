public class MinimumLimitInBag1760 {
        private static class Solution {
            public int minimumSize(int[] nums, int maxOperations) {
                int max = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    max = Math.max(max, nums[i]);
                }

                int left = 1, right = max;
                int result = max;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (isPossiblePenalty(nums, maxOperations, mid)) {
                        result = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                return result;
            }

            private boolean isPossiblePenalty(int[] nums, int maxOperations, int penalty) {
                for (int num : nums) {
                    maxOperations -= Math.max((num - 1) / penalty, 0);
                    if (maxOperations < 0) {
                        return false;
                    }
                }
                return true;
            }
        }
}
