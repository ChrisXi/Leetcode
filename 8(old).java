public class Solution {
    public int myAtoi(String str) {
        if(str.length() <= 0)
            return 0;
        
        int index = 0;
        
        for (;index < str.length(); index ++) {
            if (str.charAt(index) != 32) 
                break;
        }
        
        if (index == str.length() )
            return 0;
        
        int attr = 1;
        if(str.charAt(index) == 45 && str.length() >=2) {
            index ++;
            attr = -attr;
        } else if (str.charAt(index) == 43 && str.length() >=2) {
            index ++;
        }
        
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        boolean passZero = false;
        if(str.charAt(index) >= 48 && str.charAt(index) <= 57){
            if(str.charAt(index) != 48) {
                numbers.add(str.charAt(index)-48);
                index ++;
                passZero = true;
            } 
        } else {
            return 0;
        }
        
        for(;index < str.length(); index++) {
            if(str.charAt(index) == 48 && !passZero) {
               continue;
            } else if(str.charAt(index) >= 48 && str.charAt(index) <= 57){
               numbers.add(str.charAt(index)-48); 
               passZero = true;
            } else {
                break;
            }
        }
        
        int num = 0;
        for(int i=0; i< numbers.size(); i++) {
            if(((num == 0 && Integer.MAX_VALUE-num > numbers.get(i)) ||
                (num !=0 && Integer.MAX_VALUE-num+1 > numbers.get(i)))
                && attr == -1) {
                num += numbers.get(i)*Math.pow(10,numbers.size()-i-1);
            } else if (Integer.MAX_VALUE-num >= numbers.get(i) && attr == 1){
                num += numbers.get(i)*Math.pow(10,numbers.size()-i-1);
            } else {
                if (attr == 1)
                    return Integer.MAX_VALUE;
                else 
                    return Integer.MIN_VALUE;
            }
        }
          
        return num*attr;
    }
}