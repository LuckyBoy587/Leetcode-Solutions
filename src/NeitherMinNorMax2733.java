public class NeitherMinNorMax2733 {
    private static class Solution {
        public int findNonMinOrMax(int[] nums) {
            int min = nums[0], max = nums[0];
            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            for (int num : nums) {
                if (num != min && num != max) {
                    return num;
                }
            }
            return -1;
        }
    }
}
