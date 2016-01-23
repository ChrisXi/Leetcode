public class Solution {
    public int uniquePaths(int m, int n) {
        if(grid.length == 0)
        	return 0;

        int h = grid.length;
        int w = grid[0].length;

        int[][] dp = new int[h][w];

        dp[0][0] = grid[0][0];

        for(int i=1; i<w; i++) {
        	dp[0][i] = 1;
        }

        for(int i=1; i<h; i++) {
        	dp[i][0] = 1;
        }

        for(int i=1; i<h; i++) {
        	for(int j=1; j<w; j++) {
        		dp[i][j] = dp[i-1][j]+dp[i][j-1];
        	}
        }

        return dp[h-1][w-1];
    }
}