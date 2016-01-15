public class Solution {
    
    public int findMin(int[] nums) {
    	
    	int len = nums.length;

    	if(len == 1)
    		return nums[0];

    	if(len == 2) {
    		if(nums[0] < nums[1]) {return nums[0];}
    		else {return nums[1];}
    	}

    	if(nums[len-1] < nums[len-2])
    		return nums[len-1];


    	int s = 0;
    	int e = len-1;
    	int i = (s+e)/2;

    	while(true) {

    		if(nums[i]<nums[i+1] && nums[i]<nums[i-1]) {
    			return nums[i];
    		} else {
    			if(nums[i]<nums[0]) {
    				e = i;
    			} else {
    				s = i;
    			}
    		}

    		if(s+1 == e)
    			break;

    		i = (s+e)/2;
    	}

    	return nums[0];
    }
}