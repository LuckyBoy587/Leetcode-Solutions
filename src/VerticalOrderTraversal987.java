import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class VerticalOrderTraversal987 {
    private static class Solution {
        int _rank = 0;
        TreeMap<Integer, TreeSet<Node>> map = new TreeMap<>();

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            dfs(root, 0, 0);
            List<List<Integer>> res = new ArrayList<>();
            for (TreeSet<Node> set : map.values()) {
                List<Integer> col = new ArrayList<>();
                for (Node node : set) {
                    col.add(node.value);
                }
                res.add(col);
            }
            return res;
        }

        private void dfs(TreeNode root, int row, int col) {
            if (root == null) return;
            map.computeIfAbsent(col, _ -> new TreeSet<>()).add(new Node(root.val, row, _rank++));
            dfs(root.left, row + 1, col - 1);
            dfs(root.right, row + 1, col + 1);
        }

        private static class Node implements Comparable<Node> {
            int value, row, rank;

            public Node(int value, int row, int rank) {
                this.value = value;
                this.row = row;
                this.rank = rank;
            }

            @Override
            public int compareTo(Node o) {
                if (this.row != o.row) return Integer.compare(this.row, o.row);
                if (this.value != o.value) return Integer.compare(this.value, o.value);
                return Integer.compare(this.rank, o.rank);
            }
        }
    }
}
