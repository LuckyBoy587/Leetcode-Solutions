public class CountCompleteSubarrays2799 {
    private static class Solution {
        public int countCompleteSubarrays(int[] nums) {
            int[] freq = new int[2001];
            int totalDistinct = countDistinct(nums);
            int distinct = 0;
            int start = 0;
            int res = 0;

            for (int num : nums) {
                if (freq[num]++ == 0) distinct++;
                while (distinct == totalDistinct && freq[nums[start]] > 1) {
                    freq[nums[start++]]--;
                }
                if (distinct == totalDistinct) {
                    res += start + 1;
                }
            }

            return res;
        }

        private int countDistinct(int[] nums) {
            int res = 0;
            boolean[] visited = new boolean[2001];
            for (int num : nums) {
                if (!visited[num]) {
                    res++;
                    visited[num] = true;
                }
            }
            return res;
        }
    }
}
