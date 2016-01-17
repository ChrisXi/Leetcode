public class Solution {
    public int myAtoi(String str) {
       int len = str.length();

       long num = 0;

       boolean findChar = false;
       boolean start = false;
       int coff = 1;

       for(int i=0; i<len; i++) {
            if('0'<= str.charAt(i) && str.charAt(i) <= '9') {
                start = true;
                int n = str.charAt(i)-'0';
                num = num*10 + n;
            } else {
                if(start) {
                    return (int)num*coff;
                } else {

                    if(str.charAt(i) == '-') {
                        if(findChar)
                            return (int)num*coff;

                        coff = -1;
                        findChar = true;
                    } else if(str.charAt(i) == '+') {
                        if(findChar)
                            return (int)num*coff;

                        coff = 1;
                        findChar = true;
                    } else if(str.charAt(i) != ' ') {
                        return (int)num*coff;
                    } 
                }
            }
       }

       return (int)num*coff;
    }
}