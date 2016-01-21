/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
    }
}

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> newIntervals = new ArrayList<Interval>();

        if(intervals.size() == 0) 
        	return newIntervals;

        int left = intervals.get(0).start;
        int rightMax = intervals.get(0).end;

        for(int i=1; i<intervals.size(); i++) {
        	if(intervals.get(i).start > rightMax) {
        		newIntervals.add(new Interval(left, rightMax));

        		rightMax = intervals.get(i).end;
        		left = intervals.get(i).start;

        	} else {
        		rightMax = Math.max(rightMax, intervals.get(i).end);
        	}
        }

        newIntervals.add(new Interval(left, rightMax));

        return newIntervals;
    }
}