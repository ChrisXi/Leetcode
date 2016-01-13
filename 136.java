public class Solution {
    public int singleNumber(int[] nums) {
        
        int size = nums.length;

        int num = 0;
        for(int i=0; i<size; i++) {
        	if(i == 0) {
        		num = nums[0];
        	} else {
        		num ^= nums[i];
        	}
        }

        return num;


    }	
}