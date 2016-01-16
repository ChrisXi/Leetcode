public class Solution {
    public boolean isMatch(String s, String p) {
    	
    	int n1 = s.length();
    	int n2 = p.length();

    	int[][] match = new int[n1+1][n2+1];
    	match[0][0] = 1;

    	for(int i=1; i<=n1; i++) {
    		for(int j=1; j<=n2; j++) {
    			if(p.charAt(j-1) != '*') {
    				if((p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.') &&
    				   match[i-1][j-1] == 1) {
    					match[i][j] = 1;
    				}
    			} else {
    				if(match[i][j-1] == 1 || match[i][j-2] == 1) {
    					match[i][j] = 1;
    				} else if(match[i-1][j] == 1 && 
    					(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.')) {
    					match[i][j] = 1;
    				}
    			}
    		}
    	}

    	if(match[n1][n2] == 1) 
    		return true;

    	return false;
    }
}