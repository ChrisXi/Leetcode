public class Solution {
    public int removeDuplicates(int[] nums) {

    	int size = nums.length;

    	if(0 == size) {
    		return 0;
    	}

    	int index = 0;
    	int lastNum = nums[index];

    	index += 1;
        int len = 0;

    	for(int i=1; i<nums.length; i++) {
            if(nums[i] == lastNum) {
                if(len == 0) {
                    nums[index] = nums[i];
                    index ++;
                    len ++;
                }
            }else {
                len = 0;
    			nums[index] = nums[i];
    			index ++;
    			lastNum = nums[i];
    		} 
    	}

        return index;
    }
}