import java.util.*;

public class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        Hashtable<Integer, Integer> nums1 = new Hashtable<Integer, Integer>();
        Hashtable<Integer, Integer> nums2 = new Hashtable<Integer, Integer>();
        Hashtable<Integer, Integer> nums3 = new Hashtable<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++) {
            if(nums1.containsKey(nums[i])) {
                if(nums2.containsKey(nums[i])) {
                    nums3.put(nums[i],i);
                } else {
                    nums2.put(nums[i],i);
                }
            } else {
                nums1.put(nums[i],i);
            }
        }

        List<List<Integer>> sumNum = new ArrayList<List<Integer>>();
        
        ArrayList<Integer> numbers = new ArrayList<Integer>(nums1.keySet());
        Hashtable<Integer, Integer> indexs = new Hashtable<Integer, Integer>();
        for(int i=0; i<numbers.size(); i++){
            indexs.put(numbers.get(i),i);
        }
        for(int i=0; i<numbers.size(); i++){
            for(int j=i+1; j<numbers.size(); j++) {
                int diff = 0-numbers.get(i)-numbers.get(j);
                if(nums1.containsKey(diff)) {
                    if(indexs.get(diff) == i || indexs.get(diff) == j) {
                        if(nums2.containsKey(diff)) {
                            ArrayList<Integer> newNum = new ArrayList<Integer>();
                            
                            int min1 = numbers.get(i)<numbers.get(j) ? numbers.get(i):numbers.get(j);
                            int num1 = min1<diff ? min1:diff;
                            int num3 = numbers.get(i)+numbers.get(j)-min1>min1+diff-num1 ? numbers.get(i)+numbers.get(j)-min1:min1+diff-num1;
                            int num2 = numbers.get(i)+numbers.get(j)+diff-num1-num3;
                            
                            newNum.add(num1);
                            newNum.add(num2);
                            newNum.add(num3);
                            sumNum.add(newNum);
                            
                        } 
                    } else if(indexs.get(diff) > j){
                        ArrayList<Integer> newNum = new ArrayList<Integer>();
                      
                        int min1 = numbers.get(i)<numbers.get(j) ? numbers.get(i):numbers.get(j);
                        int num1 = min1<diff ? min1:diff;
                        int num3 = numbers.get(i)+numbers.get(j)-min1>min1+diff-num1 ? numbers.get(i)+numbers.get(j)-min1:min1+diff-num1;
                        int num2 = numbers.get(i)+numbers.get(j)+diff-num1-num3;
                        
                        newNum.add(num1);
                        newNum.add(num2);
                        newNum.add(num3);
                        sumNum.add(newNum);
                    }
                }
            }
        }
        if(nums1.containsKey(0) && nums2.containsKey(0) && nums3.containsKey(0)) {
            ArrayList<Integer> newNum = new ArrayList<Integer>();
            newNum.add(0);
            newNum.add(0);
            newNum.add(0);
            sumNum.add(newNum);
        }
        return sumNum;
    }
}