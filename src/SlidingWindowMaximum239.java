import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum239 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    private static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> deque = new ArrayDeque<>(); // Stores the index of the elements
            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
                if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) deque.pollFirst();
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
                deque.addLast(i);
                if (i >= k - 1) res[i - k + 1] = nums[deque.peek()];
            }
            return res;
        }
    }
}
