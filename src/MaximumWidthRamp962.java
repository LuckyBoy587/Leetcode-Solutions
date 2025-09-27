import java.util.Stack;

public class MaximumWidthRamp962 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxWidthRamp(new int[]{9, 8, 1, 0, 1, 0, 4, 0, 4, 0}));
    }

    private static class Solution {
        public int maxWidthRamp(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums.length; i++) {
                if (stack.isEmpty() || nums[stack.peek()] > nums[i]) stack.push(i);
            }

            int maxLen = 0;
            for (int j = nums.length - 1; j > 0 && !stack.isEmpty(); j--) {
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                    maxLen = Math.max(maxLen, j - stack.pop());
                }
            }
            return maxLen;
        }
    }
}
