public class Solution {
    public int reverse(int x) {
        if (x == 0)
            return x;
            
        int a = x;
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        double multi = 0.1;
        do {
            numbers.add(a%10);
            a /= 10;
            multi *= 10;
        }while(a != 0); 
        
        int num = 0;
        int len = numbers.size();
        for(int i=0; i<len; i++) {
            num += (int)(numbers.get(i)*multi);
            multi /= 10;
            if (i < len-1) {
                if (x < 0) {
                    if (Integer.MIN_VALUE-num > (int)(numbers.get(i+1)*multi)) {
                        return 0;
                    }
                } else {
                    if (Integer.MAX_VALUE-num < (int)(numbers.get(i+1)*multi)) {
                        return 0;
                    }
                }
                
            }
        }
        
        return num;
    }
}