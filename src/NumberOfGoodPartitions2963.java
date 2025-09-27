import java.util.HashMap;

public class NumberOfGoodPartitions2963 {
    private static class Solution {
        private static final int MOD = 1000000007;
        public int numberOfGoodPartitions(int[] nums) {
            HashMap<Integer, Integer> lastOccurrence = new HashMap<>();

            for (int i = nums.length - 1; i >= 0; i--) {
                if (!lastOccurrence.containsKey(nums[i])) {
                    lastOccurrence.put(nums[i], i);
                }
            }

            int partitions = 0;
            int currEnd = 0;

            for (int i = 0; i < nums.length; i++) {
                currEnd = Math.max(currEnd, lastOccurrence.get(nums[i]));
                if (currEnd == i) {
                    partitions++;
                    currEnd++;
                }
            }

            return getCount(partitions);
        }

        private int getCount(int num) {
            if (num <= 1) return 1;
            int res = 1;
            while (num-- > 0) {
                res *= 2;
                res %= MOD;
            }
            return res;
        }
    }
}
