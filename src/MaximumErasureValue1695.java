public class MaximumErasureValue1695 {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }

    private static class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            int maxNum = findMax(nums);
            boolean[] visited = new boolean[maxNum + 1];

            int left = 0, right = 0, res = 0, currSum = 0;
            while (right < nums.length) {
                while (right < nums.length && !visited[nums[right]]) {
                    visited[nums[right]] = true;
                    currSum += nums[right];
                    right++;
                }

                res = Math.max(res, currSum);
                if (right == nums.length) break;
                while (nums[left] != nums[right]) {
                    visited[nums[left]] = false;
                    currSum -= nums[left];
                    left++;
                }
                visited[nums[left]] = false;
                currSum -= nums[left++];
            }

            return res;
        }

        private int findMax(int[] nums) {
            int res = nums[0];
            for (int i = 1; i < nums.length; i++) {
                res = Math.max(res, nums[i]);
            }

            return res;
        }
    }
}
