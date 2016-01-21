/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> rInterval = new ArrayList<Interval>();
        if(intervals.size() == 0) {
        	rInterval.add(newInterval);
        	return rInterval;
        }

        int leftPos = 0;
        int indexLeft = -1;

        for(int i=0; i<intervals.size(); i++) {
        	if(newInterval.start <= intervals.get(i).start) {
        		leftPos = newInterval.start;
        		indexLeft = i;
        		break;
        	}

        	if(newInterval.start <= intervals.get(i).end) {
        		leftPos = intervals.get(i).start;
        		indexLeft = i;
        		break;
        	} else {
        		rInterval.add(intervals.get(i));
        	}
        }

        if(indexLeft == -1) {
        	intervals.add(newInterval);
        	return intervals;
        } 

    	int rightPos = 0;
    	int indexRight = -1;

    	for(int j=indexLeft; j<intervals.size(); j++) {
    		if (newInterval.end < intervals.get(j).start) {
    			rInterval.add(new Interval(leftPos, newInterval.end));
    			indexRight = j;
    			break;
    		} 

    		if (newInterval.end <= intervals.get(j).end) {
    			rInterval.add(new Interval(leftPos, intervals.get(j).end));	
    			indexRight = j+1;
    			break;
    		}  
    	}
        
        if(indexRight == -1) {
        	rInterval.add(new Interval(leftPos, newInterval.end));
        	return rInterval;
        }  

        for(int l=indexRight; l<intervals.size(); l++) {
        	rInterval.add(intervals.get(l));  
        }  
   
        return rInterval;  
   
    }
}