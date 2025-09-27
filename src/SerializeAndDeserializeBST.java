import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {
    private static class Codec {
        private final String delimiter = ",";
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                if (!sb.isEmpty()) sb.append(delimiter);
                sb.append(curr.val);

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            String[] tokens = data.split(delimiter);
            TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
            for (int i = 1; i < tokens.length; i++) {
                add(root, Integer.parseInt(tokens[i]));
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
