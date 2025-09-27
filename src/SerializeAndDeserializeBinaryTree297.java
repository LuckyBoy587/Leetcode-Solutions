import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SerializeAndDeserializeBinaryTree297 {
    private static class Codec {
        private final String DELIMITER = ",";
        private final String EMPTY = ".";

        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                if (!sb.isEmpty()) sb.append(DELIMITER);
                if (curr == null) {
                    sb.append(EMPTY);
                } else {
                    sb.append(curr.val);
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            StringTokenizer st = new StringTokenizer(data, DELIMITER);
            TreeNode root = new TreeNode(Integer.parseInt(st.nextToken()));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (st.hasMoreTokens()) {
                TreeNode curr = queue.poll();
                String left = st.nextToken();
                if (!left.equals(EMPTY)) {
                    curr.left = new TreeNode(Integer.parseInt(left));
                    queue.add(curr.left);
                }

                if (st.hasMoreTokens()) {
                    String right = st.nextToken();
                    if (!right.equals(EMPTY)) {
                        curr.right = new TreeNode(Integer.parseInt(right));
                        queue.add(curr.right);
                    }
                }
            }
            return root;
        }

        private void add(TreeNode root, int val) {
            if (val < root.val) {
                if (root.left == null) {
                    root.left = new TreeNode(val);
                } else {
                    add(root.left, val);
                }
            } else {
                if (root.right == null) {
                    root.right = new TreeNode(val);
                } else {
                    add(root.right, val);
                }
            }
        }
    }
}
