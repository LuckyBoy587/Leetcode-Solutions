public class SplitLinkedList725 {
    private static class Solution {
        public ListNode[] splitListToParts(ListNode head, int k) {
            int size = getSize(head);
            int npp = Math.max(size / k, 1);
            int rem = size % k;
            ListNode[] res = new ListNode[k];

            for (int index = 0; head != null; index++) {
                res[index] = head;
                int groupSize = npp + rem-- > 0 ? 1 : 0;
                while (head != null && groupSize-- > 0) {
                    head = head.next;
                }
                if (head == null) {
                    break;
                }

                ListNode next = head.next;
                head.next = null;
                head = next;
            }

            return res;
        }

        private int getSize(ListNode head) {
            if (head == null) return 0;
            return 1 + getSize(head.next);
        }
    }
}
