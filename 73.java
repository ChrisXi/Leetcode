public class Solution {
    public void setZeroes(int[][] matrix) {
        
        if(matrix.length == 0)
            return;
        
        int h = matrix.length;
        int w = matrix[0].length;

        int[] col = new int[w];
        int[] row = new int[h];

        for(int r=0; r<h; r++) {
        	for(int c=0; c<w; c++) {
        		if(matrix[r][c] == 0) {
        			col[c] = 1;
        			row[r] = 1;
        		}

        	}
        }

        for(int r=0; r<h; r++) {
        	if(row[r] == 1) {
        		for(int c=0; c<w; c++) {
        			matrix[r][c] = 0;
        		}
        	}
        }

        for(int c=0; c<w; c++) {
        	if(col[c] == 1) {
        		for(int r=0; r<h; r++) {
        			matrix[r][c] = 0;
        		}
        	}
        }
        
    }
}