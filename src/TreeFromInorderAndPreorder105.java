import java.util.HashMap;

public class TreeFromInorderAndPreorder105 {
    private static class Solution {
        int preorderIndex = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return create(preorder, 0, preorder.length - 1, map);
        }

        private TreeNode create(int[] preorder, int left, int right, HashMap<Integer, Integer> map) {
            if (left > right) return null;
            int val = preorder[preorderIndex++];
            TreeNode root = new TreeNode(val);
            int currIndex = map.get(val);
            root.left = create(preorder, left, currIndex - 1, map);
            root.right = create(preorder, currIndex + 1, right, map);
            return root;
        }
    }
}
