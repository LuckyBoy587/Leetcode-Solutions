import java.util.Arrays;

public class MaxSumOf3NonOverlappingSubarrays689 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,1,2,1};
        int k = 2;

        System.out.println(Arrays.toString(new Solution().maxSumOfThreeSubarrays(nums, k)));
    }

    private static class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int n = nums.length;
            int[] subArraySum = new int[n - k + 1];
            int windowSum = 0;
            for (int i = 0; i < n; i++) {
                windowSum += nums[i];
                if (i + 1 >= k) {
                    subArraySum[i - k + 1] = windowSum;
                    windowSum -= nums[i - k + 1];
                }
            }

            int[] leftMaxSumIndex = new int[subArraySum.length];
            for (int i = 1; i < leftMaxSumIndex.length; i++) {
                leftMaxSumIndex[i] = subArraySum[i] > subArraySum[leftMaxSumIndex[i - 1]] ? i : leftMaxSumIndex[i - 1];
            }

            int[] rightMaxSumIndex = new int[subArraySum.length];
            rightMaxSumIndex[rightMaxSumIndex.length - 1] = rightMaxSumIndex.length - 1;
            for (int i = rightMaxSumIndex.length - 2; i >= 0; i--) {
                rightMaxSumIndex[i] = subArraySum[i] >= subArraySum[rightMaxSumIndex[i + 1]] ? i : rightMaxSumIndex[i + 1];
            }

            int resI = 0, resJ = 0, resK = 0;
            int maxTotalSum = 0;

            for (int y = k; y < subArraySum.length - k; y++) {
                int x = leftMaxSumIndex[y - k];
                int z = rightMaxSumIndex[y + k];
                int currTotal = subArraySum[x] + subArraySum[z] + subArraySum[y];
                if (currTotal > maxTotalSum) {
                    maxTotalSum = currTotal;
                    resI = x;
                    resJ = y;
                    resK = z;
                }
            }

            return new int[]{resI, resJ, resK};
        }
    }
}
