public class Solution {
    public int divide(int dividend, int divisor) {
        
        if(0 == divisor) {
            return 0;
        }
        
        int factor = 1;

        if(0 < divisor) {
            divisor = 0 - divisor;
        } else {
            factor *= -1;
        }

        if(0 < dividend) {
            dividend = 0 - dividend;
        } else {
            factor *= -1;
        }

        int remain = dividend;
        int v = 0;
        
        while(remain-divisor <= 0) {
            v += 1;
            remain -= divisor;
        } 

        return v*factor;
    }
}