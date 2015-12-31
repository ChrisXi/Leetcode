public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int sum  = 0;
        int diff = Integer.MAX_VALUE;
        int size = nums.length;

        Arrays.sort(nums);

        for(int i=0; i<size-2; i++) {
        	
        	int j = i+1;
        	int k = size-1;
        	int tempDiff = Integer.MAX_VALUE;
        	int tempSum;

        	while(j < k) {
        		int n1 = nums[i];
        		int n2 = nums[j];
        		int n3 = nums[k];
        		int temp = n1+n2+n3;

        		if(temp == target) 
        			return temp;

        		if(Math.abs(temp-target) <= tempDiff) {
        			tempSum = temp;
        			tempDiff = Math.abs(temp-target);

        			if(tempDiff < diff) {
        				sum = temp;
        				diff = tempDiff;
        			}

        			if(tempSum < target) {
        				j ++;
        			} else if(tempSum > target) {
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