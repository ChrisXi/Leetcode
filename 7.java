public class Solution {
    public int reverse(int x) {
        if (x == 0)
            return x;
        
        long num = 0;
        while(x != 0) {
            num = num*10+x%10;

            if(num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if(num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            x = x/10;
        } 




        return (int)num;
    }
}