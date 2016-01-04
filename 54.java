public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        

        List<Integer> list = new ArrayList<Integer>();

        if(matrix.length == 0)
        	return list;

        int w = matrix[0].length;
        int h = matrix.length;

        int[][] map = new int[h][w];

        int r=0;
        int c=0;

        int addr=0;
        int addc=1;
        int count = 0;
        while(count != w*h) {
        	
        	list.add(matrix[r][c]);
        	map[r][c] = 1;
        	count ++;

        	int r1 = r+addr;
        	int c1 = c+addc;

        	if(r1<0 || r1>=h || c1<0 || c1>=w || map[r1][c1] == 1) {
        		if(addr == 0 && addc == 1) {
	        		addr = 1;
	        		addc = 0;
	        	} else if(addr == 1 && addc == 0) {
	        		addr = 0;
	        		addc = -1;
	        	} else if(addr == 0 && addc == -1) {
	        		addr = -1;
	        		addc = 0;
	        	} else if( addr == -1 && addc == 0) {
	        		addr = 0;
	        		addc = 1;
	        	}
        	}

        	r += addr;
        	c += addc;
        	
        }

        return list;
    }
}