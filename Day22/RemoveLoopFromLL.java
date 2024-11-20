package Day22;

import utilities.ListNode;

public class RemoveLoopFromLL {
    public ListNode solve(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) break;
        }

        slow=head;
        while(slow!=fast){
            prev=prev.next;
            slow=slow.next;
            fast=fast.next;
        }

        prev.next=null;
        return head;
    }
}
