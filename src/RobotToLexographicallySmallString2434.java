import java.util.Stack;

public class RobotToLexographicallySmallString2434 {
    public static void main(String[] args) {
        System.out.println(new Solution().robotWithString("vzhofnpo"));
    }
    private static class Solution {
        public String robotWithString(String s) {
            int n = s.length();

            char[] minRight = new char[n];
            minRight[n - 1] = s.charAt(n - 1);

            for (int i = n - 2; i >= 0; i--) {
                char currLetter = s.charAt(i);
                minRight[i] = minRight[i + 1] < currLetter ? minRight[i + 1] : currLetter;
            }

            StringBuilder res = new StringBuilder();
            Stack<Character> robot = new Stack<>();

            for (int i = 0; i < n; i++) {
                char currLetter = s.charAt(i);
                if (minRight[i] < currLetter) {
                    while (!robot.isEmpty() && robot.peek() <= minRight[i]) {
                        res.append(robot.pop());
                    }
                    robot.push(currLetter);
                } else {
                    while (!robot.isEmpty() && robot.peek() < currLetter) {
                        res.append(robot.pop());
                    }

                    res.append(currLetter);
                }
            }
            while (!robot.isEmpty()) {
                res.append(robot.pop());
            }
            return res.toString();
        }
    }
}
