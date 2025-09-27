import java.util.ArrayList;
import java.util.List;

public class CousinsInBinaryTreeII2641 {
    private static class Solution {
        List<Integer> levelSum = new ArrayList<>();
        public TreeNode replaceValueInTree(TreeNode root) {
            getLevelSum(root, 0);
            update(root, root.val, 0);
            return root;
        }

        public void getLevelSum(TreeNode root, int depth) {
            if (levelSum.size() == depth) levelSum.add(root.val);
            else levelSum.set(depth, root.val + levelSum.get(depth));
            if (root.left != null) getLevelSum(root.left, depth + 1);
            if (root.right != null) getLevelSum(root.right, depth + 1);
        }

        public void update(TreeNode root, int subValue, int depth) {
            root.val = levelSum.get(depth) - subValue;
            int leftVal = root.left == null ? 0 : root.left.val;
            int rightVal = root.right == null ? 0 : root.right.val;
            if (root.left != null) update(root.left, leftVal + rightVal, depth + 1);
            if (root.right != null) update(root.right, leftVal + rightVal, depth + 1);
        }
    }
}
