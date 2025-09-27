import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SimplifyPath71 {
    private static class Solution {
        public String simplifyPath(String path) {
            ArrayDeque<String> pathStack = new ArrayDeque<>();
            StringTokenizer tokenizer = new StringTokenizer(path, "/");

            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if (token.equals("..")) {
                    pathStack.pollLast();
                } else if (!token.equals(".") && !token.isEmpty()) {
                    pathStack.offerLast(token);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!pathStack.isEmpty()) {
                sb.append('/').append(pathStack.pollFirst());
            }

            return sb.isEmpty() ? "/" : sb.toString() ;
        }
    }
}
