public class Solution {
    public boolean canJump(int[] nums) {
    	 
		int len = nums.length;
		int maxpos = nums[0];
		for(int i=0; i<=maxpos; i++) {
// 			if(maxpos<i) 
// 			    return false;
			maxpos = i+nums[i]>maxpos ? i+nums[i]:maxpos;
			if(maxpos >= len-1) {
				return true;
			}
		}

		return false;
    }
}