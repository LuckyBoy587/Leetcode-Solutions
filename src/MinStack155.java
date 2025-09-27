import java.util.Stack;

public class MinStack155 {
    private static class MinStack {
        private static class Node {
            int value;
            int minValue;

            Node(int value, int minValue) {
                this.value = value;
                this.minValue = minValue;
            }
        }
        Stack<Node> stack;
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new Node(val, val));
            } else {
                stack.push(new Node(val, Math.min(val, stack.peek().minValue)));
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().value;
        }

        public int getMin() {
            return stack.peek().minValue;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
