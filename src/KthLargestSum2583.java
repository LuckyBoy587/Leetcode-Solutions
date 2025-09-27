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
}
