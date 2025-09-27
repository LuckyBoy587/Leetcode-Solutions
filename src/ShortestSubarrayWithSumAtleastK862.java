import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtleastK862 {
    public static void main(String[] args) {
        System.out.println(new Solution().shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167));
    }

    private static class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int[] prefixSum = new int[nums.length + 1];
            prefixSum[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            }
            int minLength = Integer.MAX_VALUE;
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i <= nums.length; i++) {
                while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                    minLength = Math.min(minLength, i - deque.pollFirst());
                }

                while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                    deque.pollLast();
                }

                deque.offerLast(i);
            }

            return minLength == Integer.MAX_VALUE ? -1 : minLength;
        }
    }
}
