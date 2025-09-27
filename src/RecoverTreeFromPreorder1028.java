import java.util.Stack;

public class RecoverTreeFromPreorder1028 {
    public static void main(String[] args) {
        System.out.println(new Solution().recoverFromPreorder("1-2--3---4-5--6---7"));
    }
    private static class Solution {
        public TreeNode recoverFromPreorder(String traversal) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode root = null;
            int index = 0;
            while (index < traversal.length()) {
                int currDepth = 0;
                while (index < traversal.length() && traversal.charAt(index) == '-') {
                    currDepth++;
                    index++;
                }

                int val = 0;
                while (index < traversal.length() && traversal.charAt(index) != '-') {
                    val = val * 10 + traversal.charAt(index) - '0';
                    index++;
                }

                TreeNode currNode = new TreeNode(val);
                if (currDepth == 0) {
                    stack.push(currNode);
                    root = currNode;
                } else {
                    while (stack.size() >= currDepth) {
                        stack.pop();
                    }

                    TreeNode parent = stack.pop();
                    if (parent.left == null) {
                        parent.left = currNode;
                    } else {
                        parent.right = currNode;
                    }

                    stack.push(currNode);
                }
            }
            return root;
        }
    }
}
