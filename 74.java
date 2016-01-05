public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
    }

    public boolean getPos(int[] pos, int[] start, int[] end, int w) {

    	int s = start[0]*w+start[1];
    	int e = end[0]*w+end[1];

    	if(s >= e)
    		return false;

    	pos[0] = ((s+e)/2)/w;
    	pos[1] = ((s+e)/2)%w;

    	return true;
    }
}