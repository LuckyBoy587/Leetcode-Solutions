import java.util.Stack;

public class LargestRectangle84 {
    private static class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> heightIndex = new Stack<>();
            int maxArea = 0;

            for (int i = 0; i <= heights.length; i++) {
                int currHeight = i == heights.length ? 0 : heights[i];
                while (!heightIndex.isEmpty() && currHeight < heights[heightIndex.peek()]) {
                    int prevHeight = heights[heightIndex.pop()];
                    int width = heightIndex.isEmpty() ? i: i - heightIndex.peek() - 1;
                    maxArea = Math.max(maxArea, prevHeight * width);
                }
                heightIndex.push(i);
            }

            return maxArea;
        }
    }
}
