public class CountSubarrayWithScoreLessThanK2302 {
    private static class Solution {
        public long countSubarrays(int[] nums, long k) {
            int start = 0;
            long count = 0, sum = 0;
            for (int end = 0; end < nums.length; end++) {
                sum += nums[end];
                int length = end - start + 1;
                while (sum * length >= k) {
                    sum -= nums[start++];
                    length--;
                }
                count += (end - start + 1);
            }
            return count;
        }
    }
}
