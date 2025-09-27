import java.util.Stack;

public class ScoreOfParanthesis856 {
    public static void main(String[] args) {
        System.out.println(new Solution().scoreOfParentheses("(()(()))"));
    }
    private static class Solution {
        public int scoreOfParentheses(String s) {
            char prev = '&';
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            int openCount = 0;
            for (char letter : s.toCharArray()) {
                if (letter == '(') {
                    stack.push(0);
                    openCount++;
                } else if (letter == ')') {
                    if (prev == '(') {
                        stack.push(stack.pop() + stack.pop() + 1);
                    } else {
                        stack.push(stack.pop() * 2);
                    }
                    openCount--;

                    if (openCount + 1 < stack.size()) {
                        stack.push(stack.pop() + stack.pop());
                    }
                }
                prev = letter;
            }
            return stack.pop();
        }
    }
}
