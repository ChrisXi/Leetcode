public class Solution {
    public String longestPalindrome(String s) {
        String str = "";
        
        for(int i=0; i<s.length()-1; i++) {
            str = check(str, s, i, i);
            str = check(str, s, i, i+1);
        }

        return str;
    }

    public String check(String str, String s, int i, int j) {
        String strNew = s.charAt(i)+"";

        int right = i+1;
        int left = i-1;

        if(i != j) {
            strNew += s.charAt(j);
            right ++;
        }

        while(right<s.length() && left>=0 && s.charAt(left)==s.charAt(right)) {
            strNew = s.charAt(left--)+strNew+s.charAt(right++);
        }

        if(strNew.length() > str.length()) {
            return strNew;
        } 

        return str;
    }

}