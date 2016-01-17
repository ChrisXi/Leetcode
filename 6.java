public class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows <= 1)
            return s;

        String str="";

        int size = (numRows-2)*2+2;
        int i = 0;
        for(int j=0; j<numRows; j++) {
            i = 0;
            while(true) {
                int index = i*size+j;

                if(index>=s.length())
                    break;

                str = str+""+s.charAt(index);

                if(j!=0 && j!=numRows-1) {
                    index = (i+1)*size-j;

                    if(index>=s.length())
                        break;

                    str = str+""+s.charAt(index);
                }
                i++;
            }
        }

        return str;
    }
}