import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumSumDifference2163 {
    public static void main(String[] args) {
        int[] nums = {7, 9, 5, 8, 1, 3};
        System.out.println(new Solution().minimumDifference(nums));
    }

    private static class Solution {
        public long minimumDifference(int[] nums) {
            long[] prefix = new long[nums.length];
            long currSum = 0;
            int subLength = nums.length / 3;
            PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
            for (int i = 0; i < nums.length; i++) {
                currSum += nums[i];
                pq.offer(nums[i]);
                if (pq.size() < subLength) {
                    prefix[i] = Integer.MAX_VALUE;
                } else {
                    if (pq.size() > subLength) {
                        currSum -= pq.poll();
                    }
                    prefix[i] = currSum;
                }
            }
            long[] suffix = new long[nums.length];
            currSum = 0;
            pq = new PriorityQueue<>();

            for (int i = nums.length - 1; i >= 0; i--) {
                currSum += nums[i];
                pq.offer(nums[i]);
                if (pq.size() < subLength) {
                    suffix[i] = Integer.MAX_VALUE;
                } else {
                    if (pq.size() > subLength) {
                        currSum -= pq.poll();
                    }
                    suffix[i] = currSum;
                }
            }

            long res = Long.MAX_VALUE;
            for (int i = subLength - 1; i < nums.length - subLength; i++) {
                long curr = prefix[i] - suffix[i + 1];
                res = Math.min(res, curr);
            }

            System.out.println(Arrays.toString(prefix));
            System.out.println(Arrays.toString(suffix));
            return res;
        }
    }
}
