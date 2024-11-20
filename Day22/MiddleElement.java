package Day22;

import utilities.ListNode;

public class MiddleElement {
    public int solve(ListNode head) {
        if(head==null || head.next==null) return head.val;

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.val;
    }
}
