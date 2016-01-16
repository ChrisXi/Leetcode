import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int num[] = new int[2];
        Hashtable<Integer,Integer> numbers = new Hashtable<Integer,Integer>();
        for(int i=0; i<nums.length; i++) {
            if (numbers.containsKey(target - nums[i])) {
                int j = numbers.get(target - nums[i]);
                num[0] = j;
                num[1] = i;
            } else {
                numbers.put(nums[i],i);
            }
        }
        
        
        return num;
    }
}