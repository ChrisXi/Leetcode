public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int noFound[] = {-1,-1};
        
        int size = nums.length;

        int pos = (int)Math.floor(size/2);
        int midValue = nums[pos];

        int start = 0;
        int end = size-1;

        
        while(midValue != target && start <= end) {

        	if(midValue < target) {
        		start = pos+1;
        	} else {
        		end = pos-1;
        	}

        	pos = (int)Math.floor((end+start)/2);
			midValue = nums[pos];
        }

        if(midValue != target)
        	return noFound;

        int leftstart = start;
        int leftend = pos;
        int leftmid = (int)Math.floor((leftstart+leftend)/2);
        int left = leftend;
        midValue = nums[leftmid]; 
        left = midValue==target ? leftmid:left;
        while(leftstart <= leftend) {
        	if(midValue != target) {
        		leftstart = leftmid+1;
        	} else {
        		leftend = leftmid-1;
        	}
        	leftmid = (int)Math.floor((leftstart+leftend)/2);
        	midValue = nums[leftmid]; 

        	left = midValue==target ? leftmid:left;
        }

        int rightstart = pos;
        int rightend = end;
        int rightmid = (int)Math.floor((rightstart+rightend)/2);
        int right = rightstart;
        midValue = nums[rightmid]; 
        right = midValue==target ? rightmid:right;
        while(rightstart <= rightend) {
        	if(midValue != target) {
        		rightend = rightmid-1;
        	} else {
        		rightstart = rightmid+1;
        	}
        	rightmid = (int)Math.floor((rightstart+rightend)/2);
        	midValue = nums[rightmid]; 

        	right = midValue==target ? rightmid:right;
        }

        noFound[0]=left;
        noFound[1]=right;



        return noFound;
    }
}




