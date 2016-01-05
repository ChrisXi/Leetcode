public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length == 0)
        	return false;

        int w = matrix[0].length;
        int h = matrix.length;

        int[] pos = new int[2];
        int[] start = new int[2];
        int[] end = new int[2];

        end[0] = h-1;
        end[1] = w-1;

        while(getPos(pos, start, end, w)) {

        	int r = pos[0];
        	int c = pos[1];

        	if(matrix[r][c] == target) {
        		return true;
        	} else if(matrix[r][c] < target) {
        		end = pos;
        	} else {
        		start = pos;
        	}
        }

        return false;

    }

    public boolean getPos(int[] pos, int[] start, int[] end, int w) {

    	int s = start[0]*w+start[1];
    	int e = end[0]*w+end[1];

    	if(e-s <= -1)
    		return false;

    	pos[0] = ((s+e)/2)/w;
    	pos[1] = ((s+e)/2)%w;

    	return true;
    }
}