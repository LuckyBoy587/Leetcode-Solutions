import java.util.Arrays;
import java.util.Comparator;

public class MarkElements3080 {
    private static class Solution {
        public long[] unmarkedSumArray(int[] nums, int[][] queries) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }

            Integer[] indexes = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                indexes[i] = i;
            }

            Arrays.sort(indexes, Comparator.comparingInt(i -> nums[i]));
            int smallestIndex = 0;
            long[] res = new long[queries.length];
            for (int i = 0; i < queries.length && sum > 0; i++) {
                int[] query = queries[i];
                sum -= nums[query[0]];
                nums[query[0]] = 0;

                while (query[1] > 0) {
                    while (smallestIndex < nums.length && nums[indexes[smallestIndex]] == 0) smallestIndex++;
                    if (smallestIndex == nums.length) break;
                    query[1]--;
                    sum -= nums[indexes[smallestIndex]];
                    nums[indexes[smallestIndex]] = 0;
                }

                res[i] = sum;
            }

            return res;
        }
    }
}
