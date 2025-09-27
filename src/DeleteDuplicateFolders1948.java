import java.util.*;

public class DeleteDuplicateFolders1948 {
    public static void main(String[] args) {
        List<List<String>> paths = List.of(
                List.of("a"),
                List.of("c"),
                List.of("a", "b"),
                List.of("c", "b"),
                List.of("a", "b", "x"),
                List.of("a", "b", "x", "y"),
                List.of("w"),
                List.of("w", "y")
        );
        Solution solution = new Solution();
        System.out.println(solution.deleteDuplicateFolder(paths));
    }
    private static class Solution {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<TrieNode>> serializedMap = new HashMap<>();
        public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
            TrieNode root = new TrieNode("root");
            for (List<String> path: paths) {
                insert(root, path, 0);
            }
            serialize(root);
            for (List<TrieNode> nodeList: serializedMap.values()) {
                if (nodeList.size() > 1) {
                    for (TrieNode node: nodeList) {
                        node.isRemoved = true;
                    }
                }
            }
            System.out.println(serializedMap);
            for (TrieNode node: root.children.values()) {
                dfs(node, new ArrayList<>());
            }
            return res;
        }

        private void dfs(TrieNode root, List<String> path) {
            if (root.isRemoved) {
                return;
            }
            path.add(root.nodeName);
            if (root.isEnd || root.children.isEmpty()) {
                res.add(new ArrayList<>(path));
            }
            for (TrieNode child: root.children.values()) {
                dfs(child, path);
            }
            path.removeLast();
        }

        private String serialize(TrieNode root) {
            if (root.children.isEmpty()) return "";
            StringBuilder curr = new StringBuilder();
            Iterator<Map.Entry<String, TrieNode>> iterator = root.children.entrySet().iterator();
            Map.Entry<String, TrieNode> entry = iterator.next();
            curr.append('(').append(entry.getKey()).append(serialize(entry.getValue()));

            while (iterator.hasNext()) {
                entry = iterator.next();
                curr.append(",").append(entry.getKey()).append(serialize(entry.getValue()));
            }
            curr.append(')');
            String res = curr.toString();
            serializedMap.computeIfAbsent(res, _ -> new ArrayList<>()).add(root);
            return res;
        }

        private void insert(TrieNode root, List<String> path, int index) {
            if (index == path.size()) {
                root.isEnd = true;
                return;
            }
            String key = path.get(index);
            if (!root.children.containsKey(key)) {
                root.children.put(key, new TrieNode(key));
            }

            root = root.children.get(key);
            insert(root, path, index + 1);
        }

        private static class TrieNode {
            Map<String, TrieNode> children = new TreeMap<>();
            String nodeName;

            public TrieNode(String nodeName) {
                this.nodeName = nodeName;
            }

            boolean isEnd = false;
            boolean isRemoved = false;

            @Override
            public String toString() {
                return nodeName;
            }
        }
    }
}
