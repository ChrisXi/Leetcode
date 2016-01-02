public class Solution {
    public int divide(int dividend, int divisor) {
        
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long divd = Math.abs((long)dividend);
        long divi = Math.abs((long)divisor);

        int remain = 0;
        while(divd >= divi) {

            if(divd == divi) {
                remain += 1;
                break;
            }

            int count = 1;
            long mul = divi << count;

            while(divd > mul) {
                count ++;
                mul = divi << count;
            }

            count --;
            remain += (1<<count);
            divd -= (divi << count);
        }

        int factor = 1;
        if(dividend < 0) {
            factor *= -1;
        }
        if(divisor < 0) {
            factor *= -1;
        }


        return remain*factor;
        
    }
}