import java.util.Hashtable;

public class Solution {

	List<List<Integer>> numsCol;
	Hashtable<String, Integer> uniqueNums;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
		this.numsCol = new ArrayList<List<Integer>>();
		this.uniqueNums = new Hashtable<String, Integer>();

		ArrayList<Integer> nums = new ArrayList<Integer>();
		Arrays.sort(candidates);
		add(nums, candidates, target);

		return this.numsCol;
    }

    public void add(ArrayList<Integer> nums, int[] candidates, int target) {

    	int size = candidates.length;

    	for(int i=0; i<size; i++) {
    		if(candidates[i]>target) {
    			return;
    		} else if(candidates[i]==target) {

    			ArrayList<Integer> temp = new ArrayList<Integer>(nums);

    			temp.add(candidates[i]);
    			Collections.sort(temp);

    			if(check(temp)) {
    				this.numsCol.add(temp);
    			}
    		} else {

    			ArrayList<Integer> temp = new ArrayList<Integer>(nums);

    			temp.add(candidates[i]);

    			add(temp, candidates, target-candidates[i]);
    		}
    	}
    }

    public boolean check(ArrayList<Integer> nums) {

    	String str = "";
    	for(int num : nums) {
    		str = str+""+num;
    	}

    	if(this.uniqueNums.containsKey(str)) {
    		return false;
    	}

    	this.uniqueNums.put(str,1);
    	return true;
    }

}