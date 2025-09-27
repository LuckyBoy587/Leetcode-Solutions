public class HouseRobber_IV_2560 {
    public static void main(String[] args) {
        System.out.println(new Solution().minCapability(new int[]{2, 3, 5, 9}, 2));
    }

    private static class Solution {
        public int minCapability(int[] nums, int k) {
            int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
            for (int num : nums) {
                left = Math.min(left, num);
                right = Math.max(right, num);
            }

            int res = -1;
            while (left <= right) {
                int capability = left + (right - left) / 2;
                if (isPossible(nums, k, capability)) {
                    res = capability;
                    right = capability - 1;
                } else {
                    left = capability + 1;
                }
            }

            return res;
        }

        private boolean isPossible(int[] nums, int k, int capability) {
            for (int i = 0; i < nums.length && k > 0; i++) {
                if (nums[i] <= capability) {
                    k--;
                    i++;
                }
            }

            return k == 0;
        }
    }
}
