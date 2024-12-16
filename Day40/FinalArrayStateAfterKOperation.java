package Day40;

import java.util.Comparator;
import java.util.PriorityQueue;

class Pair{
    public int index,value;
    public Pair(int index,int value){
        this.index=index;
        this.value=value;
    }
}

public class FinalArrayStateAfterKOperation {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n=nums.length;
        if(n==0) return new int[]{};

        Comparator<Pair> sort=(a, b)->{
            if(a.value<b.value) return -1;
            else if(a.value>b.value) return 1;
            else {
                if(a.index<b.index) return -1;
                else if(a.index>b.index) return 1;
                return 0;
            }
        };
        PriorityQueue<Pair> pq=new PriorityQueue<>(sort);
        for(int index=0;index<n;index++) pq.offer(new Pair(index,nums[index]));

        while(!pq.isEmpty() && k-->0){
            Pair temp=pq.poll();
            int value= temp.value*multiplier;
            int index=temp.index;
            pq.offer(new Pair(index,value));
            nums[index]=value;
        }
        return nums;
    }
}
