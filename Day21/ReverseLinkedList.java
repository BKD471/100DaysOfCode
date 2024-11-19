package Day21;

import utilities.ListNode;

public class ReverseLinkedList {
    private int getSizeOfList(ListNode head) {
        if (head == null) return 0;

        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) return head;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int B, int C) {
        if (head == null) return head;

        int size = getSizeOfList(head);
        if (B <= 0 || C > size) return head;
        if (B == 1 && C == size) return reverse(head);
        if (B == 1 && C == 1) return head;


        ListNode curr = head;
        ListNode prev = null;
        ListNode afterTail = null;
        ListNode beforeHead = null;
        ListNode headOfReversedNode = null;

        int indexOfNodes = 1;
        while (curr != null) {
            if (indexOfNodes == B) {
                beforeHead = prev;
                headOfReversedNode = curr;
            }
            if (indexOfNodes == C) {
                afterTail = curr.next;

                // we found out the part to be reversed
                // so dis connect the remaining part & break
                curr.next = null;
                break;
            }

            indexOfNodes++;
            prev = curr;
            curr = curr.next;
        }

        // reverse the cut out
        ListNode reversedHead = reverse(headOfReversedNode);

        //  cut out portion is at beginning
        //  so head of final LL is head of reversed one
        if (beforeHead == null) head = reversedHead;
            // else join the reversed one to original part
        else beforeHead.next = reversedHead;

        // after reverse the head of cut out part becomes the tail
        headOfReversedNode.next = afterTail;
        return head;
    }
}
