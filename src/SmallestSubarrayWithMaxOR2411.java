import java.util.Arrays;

public class SmallestSubarrayWithMaxOR2411 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().smallestSubarrays(new int[]{1, 0, 2, 1, 3})));
    }

    private static class Solution {
        public int[] smallestSubarrays(int[] nums) {
            int n = nums.length;
            int[] lastSeenBitPosition = new int[32];
            int[] res = new int[n];

            for (int i = n - 1; i >= 0; i--) {
                int curr = nums[i];
                for (int pos = 0; curr > 0; pos++) {
                    if (curr % 2 == 1) {
                        lastSeenBitPosition[pos] = i;
                    }
                    curr >>= 1;
                }

                int farthestSeenBitPosition = i;
                for (int pos = 0; pos < 32; pos++) {
                    if (lastSeenBitPosition[pos] != 0) {
                        farthestSeenBitPosition = Math.max(farthestSeenBitPosition, lastSeenBitPosition[pos]);
                    }
                }

                res[i] = farthestSeenBitPosition - i + 1;
            }

            return res;
        }
    }
}
