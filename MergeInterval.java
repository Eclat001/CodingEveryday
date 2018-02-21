package facebook;

import java.util.ArrayList;
import java.util.List;

import structure.Interval;

public class MergeInterval {
	//Time O(nlogn) Space O(1)
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        List<Interval> rst = new ArrayList<>();
        
        // Sort by ascending starting point using an anonymous Comparator (Java 8)
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for (Interval interval: intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                rst.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        
        //Add the last interval
        rst.add(new Interval(start, end));
        return rst;
    }
    
    public static void main(String[] args) {
    	List<Interval> intervals = new ArrayList<>();
    	Interval i1 = new Interval(1, 3);
    	Interval i2 = new Interval(2, 6);
    	Interval i3 = new Interval(8, 10);
    	Interval i4 = new Interval(15, 18);
    	intervals.add(i1);
    	intervals.add(i2);
    	intervals.add(i3);
    	intervals.add(i4);
    	MergeInterval mi = new MergeInterval();
    	System.out.println(mi.merge(intervals));
    	
    }
}
