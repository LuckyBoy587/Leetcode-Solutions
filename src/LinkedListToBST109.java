import java.util.ArrayList;
import java.util.List;

public class LinkedListToBST109 {
    private static class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            List<Integer> list = linkedListToList(head);
            return buildTree(list, 0, list.size() - 1);
        }

        private TreeNode buildTree(List<Integer> list, int start, int end) {
            if (start > end) return null;
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(list.get(mid));
            root.left = buildTree(list, start, mid - 1);
            root.right = buildTree(list, mid + 1, end);
            return root;
        }

        private List<Integer> linkedListToList(ListNode head) {
            List<Integer> res = new ArrayList<>();
            while (head != null) {
                res.add(head.val);
                head = head.next;
            }
            return res;
        }
    }
}
