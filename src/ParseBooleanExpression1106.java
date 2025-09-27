import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParseBooleanExpression1106 {
    public static void main(String[] args) {
        System.out.println(new Solution().parseBoolExpr("&(t,t,t)"));
    }

    private static class Solution {
        public boolean parseBoolExpr(String expression) {
            Stack<List<Boolean>> stackValues = new Stack<>();
            Stack<Character> stackSymbols = new Stack<>();

            stackValues.add(new ArrayList<>());
            for (char letter : expression.toCharArray()) {
                if (isOperator(letter)) stackSymbols.push(letter);
                else if (letter == '(') stackValues.add(new ArrayList<>());
                else if (letter == ')') {
                    boolean curr = solve(stackValues.pop(), stackSymbols.pop());
                    stackValues.peek().add(curr);
                } else if (letter != ',') {
                    stackValues.peek().add(letter == 't');
                }
            }

            return stackValues.pop().getFirst();
        }

        private boolean solve(List<Boolean> values, char sym) {
            if (sym == '&') {
                for (Boolean value : values) {
                    if (!value) return false;
                }
                return true;
            } else if (sym == '|') {
                for (Boolean value : values) {
                    if (value) return true;
                }
                return false;
            }

            return !values.getFirst();
        }

        private boolean isOperator(char letter) {
            return letter == '!' || letter == '&' || letter == '|';
        }
    }
}
