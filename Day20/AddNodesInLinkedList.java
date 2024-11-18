package Day20;

import utilities.ListNode;

public class AddNodesInLinkedList {
    public ListNode solve(ListNode head, int B, int C) {
        if(head==null){
            return new ListNode(B);
        }

        if(C==0){
            ListNode node=new ListNode(B);
            node.next=head;
            return node;
        }


        int indexOfNode=0;
        ListNode curr=head;
        ListNode prev=null;

        while(curr!=null){
            if(indexOfNode==C){
                ListNode node=new ListNode(B);
                prev.next=node;
                node.next=curr;
                return head;
            }
            indexOfNode++;
            prev=curr;
            curr=curr.next;
        }

        // insert at end
        prev.next=new ListNode(B);
        return head;
    }
}
