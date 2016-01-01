import java.util.Hashtable;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
 		List<List<Integer>> digits = new ArrayList<List<Integer>>();
 		Hashtable<String, Integer> collect = new Hashtable<String, Integer>();

 		Arrays.sort(nums);

        int size = nums.length;

        if(size < 4) 
        	return digits;

        for(int i=0; i<size-3; i++) {

        	for(int j=i+1; j<size-2; j++) {

        		int k = j+1;
        		int l = size-1;

        		while(k<l) {
        			int sum = nums[i]+nums[j]+nums[k]+nums[l];
        			if(sum == target) {

        				String str = nums[i]+""+nums[j]+""+nums[k]+""+nums[l];
        				if(!collect.containsKey(str)) {
        					List<Integer> n = new ArrayList<Integer>();
        					n.add(nums[i]);
        					n.add(nums[j]);
        					n.add(nums[k]);
        					n.add(nums[l]);
        					digits.add(n);
        					collect.put(str,1);
        				}
        				k ++;
        				l --;
        			} else if(sum < target) {
        				k ++;
        			} else {
        				l --;
        			}
        		}
        	} 
        }

        return digits;
    }
}