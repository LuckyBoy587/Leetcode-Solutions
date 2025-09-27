import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveStars3170 {
    private static class Solution {
        public String clearStars(String s) {
            List<Stack<Integer>> list = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                list.add(new Stack<>());
            }

            int n = s.length();
            boolean[] removed = new boolean[n];

            for (int i = 0; i < n; i++) {
                char curr = s.charAt(i);
                if (Character.isLetter(curr)) {
                    list.get(curr - 'a').push(i);
                } else {
                    removed[i] = true;
                    for (int charIndex = 0; charIndex < 26; charIndex++) {
                        if (!list.get(charIndex).isEmpty()) {
                            removed[list.get(charIndex).pop()] = true;
                            break;
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (!removed[i]) {
                    sb.append(s.charAt(i));
                }
            }

            return sb.toString();
        }
    }
}
