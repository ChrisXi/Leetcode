import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int num[] = new int[2];
        Hashtable<Integer,Integer> numbers = new Hashtable<Integer,Integer>();
        Hashtable<Integer,Integer> numbers2 = new Hashtable<Integer,Integer>();
        for(int i=0; i<nums.length; i++) {
            if (numbers.get(nums[i]) != null) {
                if (numbers2.get(nums[i]) == null)
                    numbers2.put(nums[i],i);
            } else {
                numbers.put(nums[i],i);
            }
        }
        for(int i=0; i<nums.length; i++) {
            if (target-nums[i] != nums[i]) {
                if (numbers.get(target-nums[i]) != null) {
                    int index = numbers.get(target-nums[i]);
                    num[0] = i<index ? i+1:index+1;
                    num[1] = i>index ? i+1:index+1;
                    return num;
                }
            } else {
                if (numbers2.get(target-nums[i]) != null) {
                    int index = numbers2.get(target-nums[i]);
                    num[0] = i<index ? i+1:index+1;
                    num[1] = i>index ? i+1:index+1;
                    return num;
                }
            }
        }
        
        return num;
    }
}