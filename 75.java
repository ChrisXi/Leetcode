public class Solution {
    public void sortColors(int[] nums) {
        if(nums.length == 0)
        	return;

        int p1 = 0;
        int p2 = nums.length-1;
        int p = 0;
        while(p1<=p2) {
        	if(nums[p1] == 0) {
        		int temp = nums[p1];
        		nums[p1] = nums[p];
        		nums[p] = temp;
        		p++;
        		p1++;
        		continue;
        	} else if(nums[p1] == 2) {
        		int temp = nums[p2];
        		nums[p2] = nums[p1];
        		nums[p1] = temp;
        		p2--;
        		continue;
        	}
        	//p1 == 1;
        	p1++;
        }
    }
}