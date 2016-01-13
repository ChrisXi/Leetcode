public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int len = gas.length;

        int acc = 0;
        for(int i=0; i<len; i++)
        	acc += (gas[i]-cost[i]);

        if(acc < 0)
        	return -1;
        
        int index = 0;
        acc = 0;
        for(int i=0; i<len; i++) {
        	acc += (gas[i]-cost[i]);
        	if(acc < 0) {
        		acc = 0;
        		index = i+1;
        	}
        }

        return index;
    }
}