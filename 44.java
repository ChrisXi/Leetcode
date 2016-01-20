public class Solution {
    public boolean isMatch(String s, String p) {
        
        int len1 = s.length();
        int len2 = p.length();

        boolean[][] dp = new boolean[len2+1][len1+1];
        dp[0][0] = true;

        for(int i=1; i<=len2; i++) {
            if(p.charAt(i-1) == '*') {
                dp[i][0] = true;
            } else {
                break;
            }
        }

        for(int i=1; i<=len2; i++) {
        	for(int j=1; j<=len1; j++) {
        		if(p.charAt(i-1) != '*') {
        			if((p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?') && dp[i-1][j-1]){
        				dp[i][j] = true;
        			}
        		} else {
        			if(dp[i-1][j-1] || dp[i-1][j]) {
        				for(int k=j; k<=len1; k++) {
        					dp[i][k] = true;
        				}
        			}
        		}
        	}
        }

        if(dp[len2][len1])
        	return true;

        return false;

    }
}