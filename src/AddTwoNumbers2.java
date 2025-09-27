public class AddTwoNumbers2 {
    private static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode base = new ListNode(-1);
            ListNode prev = base;

            while (l1 != null || l2 != null || carry != 0) {
                int sum = carry;
                if (l1 != null) sum += l1.val;
                if (l2 != null) sum += l2.val;
                carry = sum / 10;
                sum %= 10;
                prev.next = new ListNode(sum);
                prev = prev.next;

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }

            return base.next;
        }
    }
}
