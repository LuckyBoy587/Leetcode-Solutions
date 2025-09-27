public class HouseRobber_III_337 {
    private static class Solution {
        public int rob(TreeNode root) {
            Output res = dfs(root);
            return Math.max(res.robbed, res.notRobbed);
        }

        private Output dfs(TreeNode root) {
            if (root == null) return new Output(0, 0);

            Output left = dfs(root.left);
            Output right = dfs(root.right);

            int robbed = left.notRobbed + right.notRobbed + root.val;
            int notRobbed = Math.max(left.robbed, left.notRobbed) + Math.max(right.robbed, right.notRobbed);
            return new Output(robbed, notRobbed);
        }

        record Output(int robbed, int notRobbed) { }
    }
}
