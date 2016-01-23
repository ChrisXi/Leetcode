public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         if(obstacleGrid.length == 0)
        	return 0;

        int h = obstacleGrid.length;
        int w = obstacleGrid[0].length;

        int[][] dp = new int[h][w];
        
        dp[0][0] = obstacleGrid[0][0]==1 ? 0:1;
        for(int i=1; i<w; i++) {
        	if(obstacleGrid[0][i] == 1) {
    			dp[0][i] = 0;
    		} else {
    			dp[0][i] = dp[0][i-1];
    		}
        }

        for(int i=1; i<h; i++) {
        	if(obstacleGrid[0][i] == 1) {
    			dp[0][i] = 0;
    		} else {
    			dp[0][i] = dp[0][i-1];
    		}
        }

        for(int i=1; i<h; i++) {
        	for(int j=1; j<w; j++) {
        		if(obstacleGrid[i][j] == 1) {
        			dp[i][j] = 0;
        		} else {
        			dp[i][j] = dp[i-1][j]+dp[i][j-1];
        		}
        	}
        }

        return dp[h-1][w-1];
    }
}