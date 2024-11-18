package Day20;

import utilities.ListNode;

public class RemoveNthNodeFromEndOfLL {
    private ListNode reverse(ListNode head) {
        if (head == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode after = curr.next;

            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;
    }

    private int sizeOfList(ListNode head) {
        if (head == null) return 0;
        ListNode curr = head;

        int size = 0;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        return size;
    }

    public ListNode removeNthFromEnd(ListNode head, int k) {
        if (head == null) return head;

        int size = sizeOfList(head);
        if (k > size) {
            head = head.next;
            return head;
        }

        head = reverse(head);
        if (k == 1) {
            head = head.next;
            return reverse(head);
        }


        int indexOfNode = 1;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            if (indexOfNode == k) {
                prev.next = curr.next;
                return reverse(head);
            }
            indexOfNode++;
            prev = curr;
            curr = curr.next;
        }

        return reverse(head);
    }

    // Approach 2
    // without calculating the size of LL
    public ListNode removeNthFromEndAnother(ListNode head, int k) {
        if (head == null) return head;


        head = reverse(head);
        if (k == 1) {
            head = head.next;
            return reverse(head);
        }


        int indexOfNode = 1;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            if (indexOfNode == k) {
                prev.next = curr.next;
                return reverse(head);
            }
            indexOfNode++;
            prev = curr;
            curr = curr.next;
        }

        if (indexOfNode <= k) {
            head = reverse(head);
            head = head.next;
            return head;
        }

        return reverse(head);
    }
}
