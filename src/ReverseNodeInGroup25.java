public class ReverseNodeInGroup25 {
    private static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode root = new ListNode(-1);
            ListNode prevGroupEnd = root;
            ListNode currGroupStart = head;
            ListNode prevNode = null;
            int maxLen = k * (getSize(head) / k);

            int currLen = 0;
            while (head != null && currLen < maxLen) {
                ListNode next = head.next;
                head.next = prevNode;
                prevNode = head;
                head = next;
                currLen++;
                if (currLen % k == 0) {
                    prevGroupEnd.next = prevNode;
                    prevGroupEnd = currGroupStart;
                    currGroupStart = head;
                    prevNode = null;
                }
            }
            prevGroupEnd.next = head;
            return root.next;
        }

        private int getSize(ListNode head) {
            if (head == null) return 0;
            return 1 + getSize(head.next);
        }
    }
}
