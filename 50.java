import java.util.Hashtable;

public class Solution {
    
    Hashtable<Integer, Double> pow;
    public double myPow(double x, int n) {
        
        if(n == 0)
            return 1.0;
        else if(n == 1)
            return x;
        else if(n == -1)
            return 1.0/x;
        
        if(n < 0) {
            x = 1.0/x;   
            n = -n; 
        }

        pow = new Hashtable<Integer, Double>();
        pow.put(0, 1.0);
        pow.put(1, x);
        pow.put(-1, 1.0/x);
        
        int n1 = n/2;
        int n2 = n/2+n%2;
        
        return powChild(x, n1)*powChild(x, n2);
    }
    
    public double powChild(double x, int n) {
        if(Math.abs(n) < 2) {
            return this.pow.get(n);
        }

        if(pow.containsKey(n)) {
            return this.pow.get(n);
        }

        int n1 = n/2;
        int n2 = n/2+n%2;

        double mul = powChild(x, n1)*powChild(x, n2);
        pow.put(n, mul);
        

        return mul;
    }
}


