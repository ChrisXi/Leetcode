public class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;

        if(x == 0)
        	return 0;
        if(x == 1 || x == 2)
        	return 1;

        int n=(low+high)/2;
        do{
        	if(x/n >= n && x/(n+1) < n+1) 
        		return n;

        	if(x/n>n) {
        		low = n;
        	} else if(x/n<n) {
        		high = n;
        	}

        	n=(low+high)/2;

        }while(true);
    }
}