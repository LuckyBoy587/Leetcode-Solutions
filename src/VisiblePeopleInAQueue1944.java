import java.util.Arrays;
import java.util.Stack;

public class VisiblePeopleInAQueue1944 {
    public static void main(String[] args) {
        int[] heights = {10,6,8,5,11,9};
        System.out.println(Arrays.toString(new Solution().canSeePersonsCount(heights)));
    }

    private static class Solution {
        public int[] canSeePersonsCount(int[] heights) {
            int n = heights.length;
            int[] res = new int[n];
            Stack<Integer> stack = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                int count = 0;
                while (!stack.isEmpty() && heights[i] > stack.peek()) {
                    count++;
                    stack.pop();
                }

                if (!stack.isEmpty()) count++;
                res[i] = count;
                stack.push(heights[i]);
            }
            return res;
        }
    }
}
