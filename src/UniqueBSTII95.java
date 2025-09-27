import java.util.ArrayList;
import java.util.List;

public class UniqueBSTII95 {
    public static void main(String[] args) {
        System.out.println(new Solution().generateTrees(3));
    }

    private static class Solution {
        private final List<TreeNode> EMPTY = new ArrayList<>() {{
            add(null);
        }};

        public List<TreeNode> generateTrees(int n) {
            return buildTrees(1, n);
        }

        private List<TreeNode> buildTrees(int start, int end) {
            if (start > end) {
                return EMPTY;
            }
            List<TreeNode> curr = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftTrees = buildTrees(start, i - 1);
                List<TreeNode> rightTrees = buildTrees(i + 1, end);
                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = rightTree;
                        curr.add(root);
                    }
                }
            }

            return curr;
        }
    }
}
