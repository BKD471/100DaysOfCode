package Day22;

import utilities.ListNode;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if(head1==null) return head2;
        if(head2==null) return head1;

        ListNode dummyHead=new ListNode(-1);
        ListNode curr=dummyHead;


        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                curr.next=head1;
                head1=head1.next;
            }else{
                curr.next=head2;
                head2=head2.next;
            }
            curr=curr.next;
        }

        if(head1!=null) curr.next=head1;
        if(head2!=null) curr.next=head2;
        return dummyHead.next;
    }
}
