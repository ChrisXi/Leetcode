public class Solution {
    public boolean isNumber(String s) {
        
        int len = s.length();

        boolean findNumber = false;
        boolean findSpace = false;
        boolean findDot = false;
        boolean findE = false;

        for(int i=0; i<len; i++) {
        	if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
        		findNumber = true;
        		if(findSpace) {
        			return false;
        		}
        	} else if(s.charAt(i) == ' ') {
        		if(findNumber || findDot) {
        			findSpace = true;
        		}
        	} else if(s.charAt(i) == '+' || s.charAt(i) == '-') {

        		if(findNumber) {
        			if(i-1>0 && s.charAt(i-1) == 'e') {
        				continue;
        			} else {
        				return false;
        			}
        		}

        		if(findSpace) {
        			return false;
        		} 

    			if(i+1<len && (('9' < s.charAt(i+1) || s.charAt(i+1) < '0') && s.charAt(i+1) != '.')) {
					return false;
    			} 
        	} else if(s.charAt(i) == '.') {

        		if(findSpace || findE || findDot)
        			return false;

        		findDot = true;

    			if(i+1<len && (('9' < s.charAt(i+1) || s.charAt(i+1) < '0') && s.charAt(i+1) != 'e' && s.charAt(i+1) != ' ')) {
					return false;
    			} 

        	} else if(s.charAt(i) == 'e') {
        		if(findSpace || findE)
        			return false;

        		findE = true;

        		if(findNumber) {
					if(i+1>=len || '9' < s.charAt(i+1) || s.charAt(i+1) < '0') {
						return false;
        			}
        		} else {
        			return false;
        		}
        	} else {
        		return false;
        	}
        }

        if(!findNumber)
        	return false;

        return true;
    }
}