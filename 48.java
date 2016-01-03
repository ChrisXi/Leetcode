public class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        int loop = n/2;

        n = n-1;
        for(int l=0; l<loop; l++) {

        	int r=l;
        	int c=l;
        	int range = n-2*l;

        	for(int i=0; i<range; i++) {

	        	int temp = matrix[r][c+i];
	        	matrix[r][c+i] = matrix[n-(c+i)][r];
	        	matrix[n-(c+i)][r] = matrix[n-r][n-(c+i)];
	        	matrix[n-r][n-(c+i)] = matrix[c+i][n-r];
	        	matrix[c+i][n-r] = temp;
        	}
        }

    }
}