import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class NextGreaterElementIII556 {
    public static void main(String[] args) {
        System.out.println(new Solution().nextGreaterElement(15842));
    }
    private static class Solution {
        public int nextGreaterElement(int n) {
            Deque<Integer> stack = new ArrayDeque<>();
            while (n != 0) {
                stack.addFirst(n % 10);
                n /= 10;
            }

            int top = stack.removeLast();
            Queue<Integer> queue = new LinkedList<>();
            while (!stack.isEmpty() && stack.peekLast() > top) {
                queue.add(top);
                top = stack.removeLast();
            }
            if (stack.isEmpty()) return -1;
            int replace = stack.removeLast();
            int res = 0;
            while (!stack.isEmpty()) {
                res = res * 10 + stack.removeFirst();
            }
            res = res * 10 + top;
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                if (replace < curr) {
                    res = res * 10 + replace;
                    replace = Integer.MAX_VALUE;
                }
                res = res * 10 + curr;
            }

            if (replace != Integer.MAX_VALUE) res = res * 10 + replace;
            return res;
        }
    }
}
