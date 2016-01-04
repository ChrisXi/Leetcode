public class Solution {
    public int[][] generateMatrix(int n) {
        
        int r=0;
        int c=0;
        int addr=0;
        int addc=1;
        int count = 0;

        int[][] matrix = new int[n][n];

        while(count < n*n) {
        	count ++;
        	matrix[r][c] = count;

        	int r1 = r+addr;
        	int c1 = c+addc;

        	if(r1<0 || r1>=n || c1<0 || c1>=n || matrix[r1][c1] != 0) {
        		if(addr==0 && addc==1) {
        			addr = 1;
        			addc = 0;
        		} else if(addr==1 && addc==0) {
        			addr = 0;
        			addc = -1;
        		} else if(addr==0 && addc==-1) {
        			addr = -1;
        			addc = 0;
        		} else if(addr==-1 && addc==0) {
        			addr = 0;
        			addc = 1;
        		}
        	}

        	r += addr;
        	c += addc;
        }

        return matrix;
    }
}


