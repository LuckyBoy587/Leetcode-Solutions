public class MaximumAbsoluteSumOfSubarray1749 {
    private static class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int maxSum = 0, minSum = 0, currMaxSum = 0, currMinSum = 0;
            for (int num : nums) {
                currMaxSum += num;
                currMinSum += num;
                maxSum = Math.max(maxSum, currMaxSum);
                minSum = Math.min(minSum, currMinSum);
                currMaxSum = Math.max(currMaxSum, 0);
                currMinSum = Math.min(currMinSum, 0);
            }
            return Math.max(maxSum, Math.abs(minSum));
        }
    }
}
