public class Solution {
    public void nextPermutation(int[] nums) {
 		
 		if(nums.length == 0)
 			return;

 		int size = nums.length;
 		int pos = size;

 		int large = nums[size-1];
 		int largepos = size-1;
 		for(int i=size-2; i>=0; i--) {
 			if(nums[i] < large) {
 				pos = i;
 				break;
 			} 

 			if(nums[i]>large) {
 				large = nums[i];
 				largepos = i;
 			}
 		}

 		if(pos == size) {
 			sort(nums, 0, size-1);
 		} else {
 			int small = large;
 			int smallpos = largepos;
 			for(int j=pos+1; j<size; j++) {
 				if(nums[j]>nums[pos] && nums[j]<small) {
 					small = nums[j];
 					smallpos = j;
 				}
 			}
 			nums[smallpos] = nums[pos];
 			nums[pos] = small;

 			sort(nums, pos+1, size-1);
 		}

    }

    public void sort(int nums[], int start, int end) {

    	if(start >= end) 
    		return;

    	int flag = nums[end];
    	int currentPos = start;
    	for(int i=start; i<end; i++) {
    		if(nums[i] <= flag) {
    			int temp = nums[i];
    			nums[i] = nums[currentPos];
    			nums[currentPos] = temp;
    			currentPos ++;
    		} 
    	}

    	nums[end] = nums[currentPos];
		nums[currentPos] = flag;
	

    	sort(nums, start, currentPos-1);
    	sort(nums, currentPos+1, end);

    }
}


