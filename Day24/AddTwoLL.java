package Day24;

import utilities.ListNode;

public class AddTwoLL {
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
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        if(head1==null) return head2;
        if(head2==null) return head1;

        ListNode dummyHead=new ListNode(-1);
        ListNode curr=dummyHead;

        int carry=0;
        while(head1!=null && head2!=null){
            int key=head1.val+head2.val+carry;
            int remainder=key%10;
            carry=key/10;

            ListNode node=new ListNode(remainder);
            curr.next=node;

            curr=curr.next;
            head1=head1.next;
            head2=head2.next;
        }

        while(head1!=null){
            int key=head1.val+carry;
            int remainder=key%10;
            carry=key/10;

            ListNode node=new ListNode(remainder);
            curr.next=node;

            curr=curr.next;
            head1=head1.next;
        }


        while(head2!=null){
            int key=head2.val+carry;
            int remainder=key%10;
            carry=key/10;

            ListNode node=new ListNode(remainder);
            curr.next=node;

            curr=curr.next;
            head2=head2.next;
        }

        if(carry>0) curr.next=new ListNode(carry);
        return dummyHead.next;
    }
}
