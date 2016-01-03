import java.util.Hashtable;

public class Solution {

	List<List<Integer>> numsCol;
	Hashtable<String, Integer> uniqueNums;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		this.numsCol = new ArrayList<List<Integer>>();
		this.uniqueNums = new Hashtable<String, Integer>();

		ArrayList<Integer> nums = new ArrayList<Integer>();
		Arrays.sort(candidates);

        ArrayList<Integer> candidatesArray = new ArrayList<Integer>();
        for(int i=0; i<candidates.length; i++) {
            candidatesArray.add(candidates[i]);
        }
        

		add(nums, candidatesArray, target);

		return this.numsCol;
    }

    public void add(ArrayList<Integer> nums, ArrayList<Integer> candidates, int target) {

    	int size = candidates.size();

    	for(int i=0; i<size; i++) {
    		if(candidates.get(i)>target) {
    			return;
    		} else if(candidates.get(i)==target) {

    			ArrayList<Integer> temp = new ArrayList<Integer>(nums);

    			temp.add(candidates.get(i));
    			Collections.sort(temp);

    			if(check(temp)) {
    				this.numsCol.add(temp);
    			}
    		} else {

    			ArrayList<Integer> temp = new ArrayList<Integer>(nums);
    			temp.add(candidates.get(i));

                ArrayList<Integer> candidatesArray = new ArrayList<Integer>(candidates);
                candidatesArray.remove(i);

    			add(temp, candidatesArray, target-candidates.get(i));
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