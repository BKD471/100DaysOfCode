package Day23;

import utilities.ListNode;

public class SortList {
    private ListNode getMiddle(ListNode head) {
        if (head == null) return head;

        ListNode fast = head, slow = head, prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = new ListNode(head1.val);
                head1 = head1.next;
            } else {
                curr.next = new ListNode(head2.val);
                head2 = head2.next;
            }
            curr = curr.next;
        }

        if (head1 != null) curr.next = head1;
        if (head2 != null) curr.next = head2;
        return dummyHead.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middle = getMiddle(head);
        ListNode head2 = middle.next;
        middle.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(head2);
        return merge(left, right);
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(8);
        a.next = b;
        b.next = c;
        c.next = d;


        SortList sortList = new SortList();
        ListNode res = sortList.sortList(a);
        sortList.printList(res);
    }
}
