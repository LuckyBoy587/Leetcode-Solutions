public class LongestIncOrDecSubarray3105 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestMonotonicSubarray(new int[]{1, 4, 3, 3, 2}));
    }

    private static class Solution {
        public int longestMonotonicSubarray(int[] nums) {
            int windowLen = 1, maxLen = 1;
            boolean isIncreasing = true;

            for (int i = 1; i < nums.length; i++) {
                if ((isIncreasing && nums[i - 1] >= nums[i]) || (!isIncreasing && nums[i - 1] <= nums[i])) {
                    if (nums[i] != nums[i - 1]) {
                        windowLen = 1;
                    } else {
                        windowLen = 0;
                    }
                    isIncreasing = !isIncreasing;
                }

                windowLen++;
                maxLen = Math.max(maxLen, windowLen);
            }

            return maxLen;
        }
    }
}
