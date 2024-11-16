package Day18;

import utilities.Interval;

import java.util.ArrayList;

public class MergeInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<>();
        int n = intervals.size();

        int index = 0;
        while (index < n) {
            int currentStartTime = intervals.get(index).start;
            int currentEndTime = intervals.get(index).end;

            if (currentEndTime < newInterval.start) res.add(intervals.get(index));
            else if (currentStartTime > newInterval.end) {
                res.add(newInterval);
                while (index < n) res.add(intervals.get(index++));
                return res;
            } else {
                newInterval.start = Math.min(newInterval.start, currentStartTime);
                newInterval.end = Math.max(newInterval.end, currentEndTime);
            }
            index++;
        }
        res.add(newInterval);

        return res;
    }
}
