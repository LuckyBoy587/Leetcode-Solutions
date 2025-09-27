import java.util.Arrays;

public class ZeroArray3356 {
    public static void main(String[] args) {
        int[] nums = {7, 6, 8};
        int[][] queries = {
                {0, 0, 2},
                {0, 1, 5},
                {2, 2, 5},
                {0, 2, 4}
        };
        System.out.println(new Solution().minZeroArray(nums, queries));
    }
    private static class Solution {
        public int minZeroArray(int[] nums, int[][] queries) {
            int res = -1;
            int i = 1, j = queries.length;
            while (i <= j) {
                int mid = i + (j - i) / 2;
//                System.out.println(mid);
                if (isPossible(nums, queries, mid)) {
                    res = mid;
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
            return res;
        }

        private boolean isPossible(int[] nums, int[][] queries, int k) {
            int[] overlapping = new int[nums.length + 1];
            for (int i = 0; i < k; i++) {
                int[] query = queries[i];
                int start = query[0], end = query[1], weight = query[2];
                overlapping[start] += weight;
                overlapping[end + 1] -= weight;
            }
            int currSum = 0;
            for (int i = 0; i < nums.length; i++) {
                currSum += overlapping[i];
                if (currSum < nums[i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
