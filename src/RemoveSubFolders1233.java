import java.util.*;

public class RemoveSubFolders1233 {
    private static class Solution {
        static class TrieNode {
            HashMap<String, TrieNode> children = new HashMap<>();
            boolean isEnd;
        }

        public List<String> removeSubfolders(String[] folder) {
            Arrays.sort(folder);
            TrieNode root = new TrieNode();
            List<String> res = new ArrayList<>();
            for (String f : folder) {
                if (!parentExists(root, new StringTokenizer(f, "/"))) {
                    res.add(f);
                }
            }

            return res;
        }

        private boolean parentExists(TrieNode root, StringTokenizer st) {
            if (!st.hasMoreTokens()) {
                root.isEnd = true;
                return false;
            }
            String token = st.nextToken();
            if (!root.children.containsKey(token)) {
                root.children.put(token, new TrieNode());
            }

            return root.isEnd || parentExists(root.children.get(token), st);
        }
    }
}
