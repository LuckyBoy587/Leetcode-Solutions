import java.util.HashMap;

public class TreeFromPreorderPostorder889 {
    private static class Solution {
        HashMap<Integer, Integer> map;
        int index = 1;
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            map = new HashMap<>();
            for (int i = 0; i < postorder.length; i++) {
                map.put(postorder[i], i);
            }
            return buildTree(preorder, postorder.length);
        }

        private TreeNode buildTree(int[] preorder, int parentIndex) {
            if (index >= preorder.length) return null;
            int currIndex = map.get(preorder[index]);
            TreeNode root = new TreeNode(preorder[index]);
            if (currIndex > parentIndex) return null;
            index++;
            root.left = buildTree(preorder, currIndex);
            root.right = buildTree(preorder, currIndex);
            return root;
        }
    }
}
