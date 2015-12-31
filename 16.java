public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int sum ＝ 0;
        int diff = Integer.MAX_VALUE;
        int size = nums.length;

        Array.sort(nums);

        for(int i=0; i<size-1; i++) {
        	
        	int j = i+1;
        	int k = size-1;

        	while(j < k) {
        		int n1 = nums[i];
        		int n2 = nums[j];
        		int n3 = nums[k];
        		int temp = n1+n2+n3;

        		if(temp == target) 
        			return temp;

        		if(Math.abs(sum-target) < diff) {
        			sum = temp;
        			diff = Math.abs(sum-target);
        			if(sum < target) {
        				j ++;
        			} else if(sum > target) {
        				k --;
        			}
        		} else {
        			break;
        		}
        	}
        }

        return sum;
    }
}