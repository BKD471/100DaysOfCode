package Day20;

import utilities.ListNode;

public class DeleteNodesInLinkedList {
    public ListNode solve(ListNode head, int k) {
        if (head == null) return null;

        if (k == 0) {
            head = head.next;
            return head;
        }

        int indexOfNodes = 0;
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (indexOfNodes == k) {
                prev.next = curr.next;
                return head;
            }
            indexOfNodes++;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
