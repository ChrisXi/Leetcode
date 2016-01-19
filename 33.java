public class Solution {
    public int search(int[] nums, int target) {
        
        int len = nums.length;

        int start = 0;
        int end = len-1;
        for(int i=0; i<len; i++) {
        	
        	if(target > nums[mid]) {
        		if(target > nums[start]) {
        			if(nums[mid] > nums[start]) {
        				start = mid+1;
        			} else {
        				end = mid-1;
        			}
        		} else {
        			start = mid+1;
        		}
        	} else if(target < nums[mid]) {
        		if(target > nums[start]) {
        			end = mid-1;
        		} else {
        			if(nums[mid] > nums[start]) {
        				start = mid+1;
        			} else {
        				end = mid-1;
        			}
        		}
        	} else {
        		return mid;
        	}
        }

        return -1;
    }
}