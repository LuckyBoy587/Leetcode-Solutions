public class LongestUnivaluePath687 {
    private static class Solution {
        private static final int EMPTY = 999999999;
        int maxLength = 1;
        public int longestUnivaluePath(TreeNode root) {
            if (root == null) return 0;
            find(root);
            return maxLength - 1;
        }

        private Output find(TreeNode root) {
            if (root == null) return new Output(EMPTY, 0);
            if (root.left == null && root.right == null) {
                return new Output(root.val, 1);
            }
            Output left = find(root.left);
            Output right = find(root.right);

            if (root.val == left.value && root.val == right.value) {
                maxLength = Math.max(maxLength, left.count + right.count + 1);
                return new Output(root.val, Math.max(left.count, right.count) + 1);
            } else if (root.val == left.value) {
                maxLength = Math.max(maxLength, left.count + 1);
                return new Output(root.val, left.count + 1);
            } else if (root.val == right.value) {
                maxLength = Math.max(maxLength, right.count + 1);
                return new Output(root.val, right.count + 1);
            }

            return new Output(root.val, 1);
        }

        record Output(Integer value, int count) { }
    }
}
