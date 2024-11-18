package Day20;

import utilities.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class CopyLinkedList {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode,RandomListNode> hash=new HashMap<>();

        RandomListNode curr=head;
        while(curr!=null){
            int key=curr.label;
            RandomListNode node=new RandomListNode(key);
            hash.put(curr,node);
            curr=curr.next;
        }


        curr=head;
        while(curr!=null){
            RandomListNode node=hash.get(curr);
            RandomListNode nextNode=hash.get(curr.next);
            RandomListNode randomNode=hash.get(curr.random);

            node.next=nextNode;
            node.random=randomNode;
            curr=curr.next;
        }
        return hash.get(head);
    }
}
