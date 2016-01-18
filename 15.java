import java.util.*;

public class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        

        List<List<Integer>> sums = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        int len = nums.length;

        for(int i=0; i<len; ) {
            if(nums[i] > 0)
                break;
            int s = i+1;
            int e = len-1;
            while(s<e) {
                int sum = nums[i]+nums[s]+nums[e];
                if(sum == 0) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[s]);
                    temp.add(nums[e]);
                    sums.add(temp);

                    int num = nums[s];
                    while(s<=e && nums[s]==num) {
                        s++;
                    }
                    num = nums[e];
                    while(s<=e && nums[e]==num) {
                        e--;
                    }
                } else if(sum < 0) {
                    s ++;
                } else {
                    e --;
                }
            }

            int num = nums[i];
            while(i<len && num[i]==num) {
                i++;
            }
        }
        
        return sums;
    }
}