public class Solution {
    public boolean isPalindrome(String s) {
        
        int len = s.length();

        int p1 = 0;
        int p2 = len-1;

        while(p1<p2) {
        	while(!check(p1, s)) {
        		p1++;
        		if(p1 > p2) 
        			return true;
        	}
        	while(!check(p2, s)) {
        		p2--;
        		if(p2 < p1)
        			return true;
        	}

        	if(checkEqual(p1, p2, s)) {
        		p1 ++;
        		p2 --;
        	} else {
        		return false;
        	}
        }

        return true;
    }

    public boolean checkEqual(int p1, int p2, String s) {
    	int d1 = s.charAt(p1)-'0';
    	int d2 = s.charAt(p2)-'0';

    	if(d1 == d2 || (Math.abs(d1-d2) == 32 && d1 > 9 && d2 > 9))
    		return true;

    	return false;
    }

    public boolean check(int p, String s) {

    	if(s.charAt(p)-'0'<0)
    		return false;
    	if(s.charAt(p)-'9'>0 && s.charAt(p)-'A'<0) 
    		return false;
    	if(s.charAt(p)-'Z'>0 && s.charAt(p)-'a'<0)
    		return false;
    	if(s.charAt(p)-'z'>0)
    		return false;

    	return true;
    }
}