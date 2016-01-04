public class Solution {
    public int lengthOfLastWord(String s) {
        
        int len = s.length();
        if(len == 0) 
        	return 0;

        int end = len-1;

        while(end > 0 && s.charAt(end) == ' ') {
        	end --;
        }

        if(end == 0 && s.charAt(end) == ' ')
        	return 0;

        int start = end;

        while(start > 0 && s.charAt(start) != ' ') {
        	start --;
        }

        int add = 0;
        if(s.charAt(start) != ' ')
        	add = 1;

        return end-start+add;
    }
}