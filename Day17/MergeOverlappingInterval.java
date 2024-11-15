package Day17;

import utilities.Interval;

import java.util.ArrayList;
import java.util.Collections;

public class MergeOverlappingInterval {

    // O(nlog(n) + n)
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int n=intervals.size();
        if(n==0) return new ArrayList<>();

        // O(nlogn)
        Collections.sort(intervals,(a, b)->a.start-b.start);

        int compareIndex=0;
        //O(n)
        for(int i=1;i<n;i++){
            Interval currentInterval=intervals.get(i);
            int currentStartTime=currentInterval.start;
            int currentEndTime=currentInterval.end;
            if(intervals.get(compareIndex).end>=currentStartTime){
                intervals.get(compareIndex).start=Math.min(intervals.get(compareIndex).start,currentStartTime);
                intervals.get(compareIndex).end=Math.max(intervals.get(compareIndex).end,currentEndTime);
            }else{
                compareIndex++;
                intervals.set(compareIndex,intervals.get(i));
            }
        }

        ArrayList<Interval> res=new ArrayList<>();
        for(int i=0;i<=compareIndex;i++) res.add(intervals.get(i));
        return res;
    }
}
