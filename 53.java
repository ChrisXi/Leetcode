public class Solution {
    public int maxSubArray(int[] nums) {

    	int len = nums.length;
    	if(len == 0)
    		return 0;

        int start = 0;
        int end = 0;

        int curMax = nums[0];
        

        for(int i=0; i<len; i++) {
        	if(nums[i] > 0) {
        		curMax = nums[i];
        		start = i;
        		end = i;
        		break;
        	}

        	if(nums[i] > curMax) {
        		curMax = nums[i];
        	}
        }

        if(curMax <= 0)
        	return curMax;

        //curSum > 0
        int curSum = curMax;
        boolean restart = false;
        for(int i=start+1; i<len; i++) {

        	if(restart) {
        		if(nums[i] >= 0) {
        			curSum = nums[i];
        			if(curMax < curSum) {
        				curMax = curSum;
        			}
        			restart = false;
        		}
        		continue;
        	} 

        
    		curSum = curSum+nums[i];
    		if(curMax < curSum) {
    			curMax = curSum;
    		}
        	
        	if(curSum+nums[i] <= 0){
        		restart = true;
        	}
        }

        return curMax;
    }
}