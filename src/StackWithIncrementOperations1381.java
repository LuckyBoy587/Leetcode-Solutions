public class StackWithIncrementOperations1381 {
    static class CustomStack {
        int[] stack;
        int index = -1;
        public CustomStack(int maxSize) {
            stack = new int[maxSize];
        }

        public void push(int x) {
            if (index + 1 < stack.length) {
                stack[++index] = x;
            }
        }

        public int pop() {
            return index >= 0 ? stack[index--] : -1;
        }

        public void increment(int k, int val) {
            for (int i = 0; i < Math.min(k, index + 1); i++) {
                stack[i] += val;
            }
        }
    }
}
