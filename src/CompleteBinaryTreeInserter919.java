import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CompleteBinaryTreeInserter919 {
    private static class CBTInserter {
        List<TreeNode> nodeList = new ArrayList<>();
        public CBTInserter(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    assert node != null;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    nodeList.add(node);
                }
            }
        }

        public int insert(int val) {
            int index = nodeList.size();
            TreeNode node = new TreeNode(val);
            nodeList.add(node);
            TreeNode parent = nodeList.get((index - 1) / 2);
            if (parent.left == null) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            return parent.val;
        }

        public TreeNode get_root() {
            return nodeList.getFirst();
        }
    }
}
