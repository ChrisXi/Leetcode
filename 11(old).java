public class Solution {
    public int maxArea(int[] height) {
        if(height.length < 2)
            return 0;
            
        int highestIndex = 0;
        int highest = height[0];
        for(int i=1; i<height.length; i++) {
            if(height[i]>highest) {
                highestIndex = i;
                highest = height[i];
            }
        }
        
        int highestOnLeft = height[0];
        int highestOnRight = height[height.length-1];
        
        for(int i=0; i<highestIndex; i++) {
            
            if(height[i]<highestOnLeft) {
                height[i] = 0;
            } else {
                highestOnLeft = height[i];
            }
        }
        
        for(int i=highestIndex; i>height.length-1; i--) {
             if(height[i]<highestOnRight) {
                height[i] = 0;
            } else {
                highestOnRight = height[i];
            }
        }
        
        int indexLeft = 0;
        int indexRight = height.length-1;
        int maxHeight = height[indexLeft]<height[indexRight] ? height[indexLeft]:height[indexRight];
        int maxArea = maxHeight*(indexRight-indexLeft);
        
        while(indexLeft<indexRight) {
            if(height[indexLeft]>height[indexRight]) {
                do{
                    indexRight--;
                }while(height[indexRight] == 0);
            } else {
                do{
                    indexLeft++;
                }while(height[indexLeft] == 0);
            }
            maxHeight = height[indexLeft]<height[indexRight] ? height[indexLeft]:height[indexRight];
            int tempArea = maxHeight*(indexRight-indexLeft);

            maxArea = maxArea>tempArea ? maxArea:tempArea;
        }
        
        return maxArea;
    }
}