public class Solution {
    public int jump(int[] nums) {
        
        int len = nums.length;

        int step = 0;
        for(int i=0; i<len-1;) {

            int jumpLen = nums[i];
            int nextIndex = i;
            int maxStep = 0;
            for(int j=1; j<=jumpLen; j++) {
                if(i+j>=len-1) {
                    step ++;
                    return step;
                }
                if(maxStep < j+nums[i+j]) {
                    nextIndex = i+j;
                    maxStep = j+nums[i+j];
                }
            }

            step ++;
            i = nextIndex;
        }

        return step;
    }
}