public class Solution {
    public int searchInsert(int[] nums, int target) {
        
    	int size = nums.length;

    	int pos = size;

    	for(int i=0; i<size; i++) {

    		if(nums[i] < target) {
    			continue;
    		} else {
    			pos = i;
    			break;
    		}
    	}

    	if(pos == size || pos == -1)
    		pos = nums[0]>target ? 0:size;

    	return pos;
    }
}