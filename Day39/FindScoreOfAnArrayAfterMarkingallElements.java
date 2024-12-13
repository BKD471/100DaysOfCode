package Day39;

import java.util.Comparator;
import java.util.PriorityQueue;

class Pair{
    int index,value;
    Pair(int index,int value){
        this.index=index;
        this.value=value;
    }
}

public class FindScoreOfAnArrayAfterMarkingallElements {
    public long findScore(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;

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


        long res=0;
        while(!pq.isEmpty()){
            Pair temp=pq.poll();

            int index=temp.index;
            if(nums[index]==-1) continue;

            if(index>0) nums[index-1]=-1;
            if(index<n-1) nums[index+1]=-1;
            res+=nums[index];
        }
        return res;

    }
}
