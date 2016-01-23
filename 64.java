public class Solution {
    public int minPathSum(int[][] grid) {
        
        if(grid.length == 0)
        	return 0;

        int h = grid.length;
        int w = grid[0].length;

        int[][] dp = new int[h][w];

        dp[0][0] = grid[0][0];

        for(int i=1; i<w; i++) {
        	dp[0][i] = grid[0][i];
        }

        for(int i=1; i<h; i++) {
        	dp[i][0] = grid[i][0];
        }
    }
}