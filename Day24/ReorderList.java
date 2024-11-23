package Day24;

import utilities.ListNode;

public class ReorderList {
    private ListNode findMiddle(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode fast=head,slow=head,prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        return prev;
    }

    private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode curr=head,prev=null;
        while(curr!=null){
            ListNode after=curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }
        return prev;
    }
    public ListNode reorderList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode middleNode=findMiddle(head);

        ListNode head2=middleNode.next;
        middleNode.next=null;
        head2=reverse(head2);

        ListNode dummyHead=new ListNode(-1);
        ListNode curr=dummyHead;

        boolean appendFirst=true;
        while(head!=null && head2!=null){
            if(appendFirst){
                curr.next=head;
                head=head.next;
                appendFirst=!appendFirst;
            }else{
                curr.next=head2;
                head2=head2.next;
                appendFirst=!appendFirst;
            }
            curr=curr.next;
        }

        if(head!=null) curr.next=head;
        if(head2!=null) curr.next=head2;

        return dummyHead.next;
    }
}
