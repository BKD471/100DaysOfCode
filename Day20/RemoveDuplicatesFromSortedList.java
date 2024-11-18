package Day20;

import utilities.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val != temp.val) {
                temp.next = new ListNode(curr.val);
                temp = temp.next;
            }
            curr = curr.next;
        }

        return dummyHead.next;
    }
}
