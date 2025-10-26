import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestSum2583 {
    private static class Solution {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        public long kthLargestLevelSum(TreeNode root, int k) {
            Queue<TreeNode> queue = new LinkedList<>();
            pq.add((long) root.val);
            if (root.left != null) queue.add(root.left);
            if (root.right != null) queue.add(root.right);
            while (!queue.isEmpty()) {
                int size = queue.size();
                long sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                    sum += node.val;
                }
                if (pq.size() < k) pq.add(sum);
                else if (sum > pq.peek()) {
                    pq.poll();
                    pq.add(sum);
                }
            }
            if (pq.size() == k) return pq.peek();
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Example 1
        TreeNode root1 = buildTree(new Integer[]{5,8,9,2,1,3,7,4,6});
        long result1 = sol.kthLargestLevelSum(root1, 2);
        assert result1 == 13 : "Example 1 failed: expected 13, got " + result1;
        // Example 2
        TreeNode root2 = buildTree(new Integer[]{1,2,null,3});
        long result2 = sol.kthLargestLevelSum(root2, 1);
        assert result2 == 3 : "Example 2 failed: expected 3, got " + result2;
        System.out.println("All tests passed!");
    }

    private static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode node = queue.poll();
            if (arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                queue.add(node.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
