package Day22;

import utilities.ListNode;

public class SwapNodesInPair {
    private void reverse(ListNode head) {
        if (head == null) return;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode after = curr.next;
            curr.next = prev;

            prev = curr;
            curr = after;
        }
    }

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k-- > 1) curr = curr.next;
        return curr;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode kthNode = getKthNode(curr, 2);
            if (kthNode == null) {
                if (prev != null) prev.next = curr;
                break;
            }

            ListNode after = kthNode.next;
            kthNode.next = null;

            reverse(curr);
            if (curr == head) head = kthNode;
            else prev.next = kthNode;

            prev = curr;
            curr = after;
        }
        return head;
    }
}
