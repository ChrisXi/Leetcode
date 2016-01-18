public class Solution {
    public int maxArea(int[] height) {
     
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;

        while(left < right) {
            int minH = Math.min(height[left], height[right]);
            if(maxArea < (right-left)*minH) {
                maxArea = (right-left)*minH;
            }

            if(height[left] > height[right]) {
                right --;
            } else {
                left ++;
            }
        }

        return maxArea;
    }
}