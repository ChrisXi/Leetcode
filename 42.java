public class Solution {
    public int trap(int[] height) {
        
        int len = height.length;

        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        
        int max = 0;
        for(int i=0; i<len; i++) {
        	leftMax[i] = max;
        	max = Math.max(height[i], max);
        }

        max = 0;
        for(int i=len-1; i>=0; i--) {
        	rightMax[i] = max;
        	max = Math.max(height[i], max);
        }

        int water = 0;
        for(int i=0; i<len; i++) {
        	if(height[i]<rightMax[i] && height[i]<leftMax[i]) {
        		int min = Math.min(rightMax[i], leftMax[i]);
        		water += (min-height[i]);
        	}
        }

        return water;
    }
}