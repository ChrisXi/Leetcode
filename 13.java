import java.util.Hashtable;

public class Solution {
    public int romanToInt(String s) {
        int len = s.length();
        
        Hashtable<String, Integer> map = new Hashtable<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        
        int n = 0;
     	int level = 0;
        for(int i=len-1; i>=0; i--) {

        	int num = map.get(s.charAt(i)+"");

        	if(level > num) 
        		level = num;

            if(num >= level) {
            	n += num;
            } else {
            	n -= num;
            }
        }

        return n;
    }
}