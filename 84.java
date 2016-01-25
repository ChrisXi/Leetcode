public class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int len = heights.length;

        return area(0, len-1, heights);
    }

    public int area(int s, int e, int[] heights) {
    	if(s>e) {
    		return 0;
    	}

    	int min = heights[s];
    	int mid = s;
    	for(int i=s+1; i<=e; i++) {
    		if(heights[i]<min) {
    			min = heights[i];
    			mid = i;
    		}
    	}

    	int area = min*(e-s+1);
    	int area1 = area(s, mid-1, heights);
    	int area2 = area(mid+1, e, heights);

    	return Math.max(area, Math.max(area1, area2));
    }
}