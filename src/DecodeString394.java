import java.util.Queue;
import java.util.Stack;

public class DecodeString394 {
    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
        // abcabccdcdcdef
        // abcabccdcdcdef
    }
    private static class Solution {
        public String decodeString(String s) {
            Stack<Integer> repeatCount = new Stack<>();
            Stack<StringBuilder> sbStack = new Stack<>();
            char[] letters = s.toCharArray();

            if (Character.isDigit(letters[0])) {
                repeatCount.push(letters[0] - '0');
                sbStack.push(new StringBuilder());
            } else {
                sbStack.push(new StringBuilder(String.valueOf(letters[0])));
            }

            for (int i = 1; i < letters.length; i++) {
                char letter = letters[i];
                if (Character.isDigit(letter)) {
                    int prevValue = Character.isDigit(letters[i - 1]) ? 10 * repeatCount.pop() : 0;
                    repeatCount.push(prevValue + letter - '0');
                } else if (Character.isLetter(letter)) {
                    sbStack.push(sbStack.pop().append(letter));
                } else if (letter == '[') {
                    sbStack.push(new StringBuilder());
                } else {
                    int repeatTimes = repeatCount.pop();
                    StringBuilder repeatedSB = new StringBuilder().repeat(sbStack.pop(), repeatTimes);
                    sbStack.push(sbStack.pop().append(repeatedSB));
                }
            }

            return sbStack.pop().toString();
        }
    }
}
