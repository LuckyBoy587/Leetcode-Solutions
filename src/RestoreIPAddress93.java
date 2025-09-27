import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress93 {
    public static void main(String[] args) {
        String s = "001000";
        Solution solution = new Solution();
        List<String> result = solution.restoreIpAddresses(s);
        System.out.println(result);
    }

    private static class Solution {
        List<String> result = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            dfs(s, 0, new ArrayList<>());
            return result;
        }

        private void dfs(String word, int start, List<String> path) {
            if (start == word.length()) {
                if (path.size() == 4) {
                    result.add(String.join(".", path));
                }
                return;
            }
            StringBuilder curr = new StringBuilder();
            int currValue = 0;

            do {
                char currDigit = word.charAt(start);
                currValue = currValue * 10 + (currDigit - '0');
                if (currValue <= 255) {
                    curr.append(currDigit);

                    path.add(curr.toString());
                    dfs(word, start + 1, path);
                    path.removeLast();
                }

            } while (++start < word.length() && currValue <= 255 && currValue > 0);
        }
    }
}
