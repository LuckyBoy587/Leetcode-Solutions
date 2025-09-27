import java.util.HashMap;

public class TreeFromInorderAndPostorder106 {
        private static class Solution {
            int postorderIndex = 0;
            public TreeNode buildTree(int[] inorder, int[] postorder) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < inorder.length; i++) {
                    map.put(inorder[i], i);
                }

                postorderIndex = postorder.length - 1;
                return create(postorder, 0, inorder.length - 1, map);
            }

            private TreeNode create(int[] postorder, int left, int right, HashMap<Integer, Integer> map) {
                if (left > right) return null;
                int val = postorder[postorderIndex--];
                TreeNode root = new TreeNode(val);
                int currIndex = map.get(val);

                root.right = create(postorder, currIndex + 1, right, map);
                root.left = create(postorder, left, currIndex - 1, map);
                return root;
            }
        }
}
