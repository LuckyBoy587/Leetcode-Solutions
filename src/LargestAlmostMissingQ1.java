public class LargestAlmostMissingQ1 {
    public static void main(String[] args) {
        System.out.println(new Solution().largestInteger(new int[]{3,9,2,1,7}, 3));
    }
    private static class Solution {
        public int largestInteger(int[] nums, int k) {
            int[] freq = new int[51];
            int n = nums.length;

            for (int i = k; i <= n; i++) {
                boolean[] visited = new boolean[51];
                for (int j = i - k; j < i; j++) {
                    if (!visited[nums[j]]) {
                        freq[nums[j]]++;
                        visited[nums[j]] = true;
                    }
                }
            }

            for (int num = 50; num >= 0; num--) {
                if (freq[num] == 1) {
                    return num;
                }
            }
            return -1;
        }
    }
}
