public class Solution {
    public String reverseWords(String s) {
        int len = s.length();

        String str = "";
        String temp = "";

        int i=0;
        while(i<len) {
        	if(s.charAt(i) == ' ') {
        		if(!temp.equals("")) {
        			str = str+" "+temp;
        		}
        		temp = "";
        	} else {
        		temp = temp + "" + s.charAt(i);
        	}
        	i++;
        }

        return str;
    }
}