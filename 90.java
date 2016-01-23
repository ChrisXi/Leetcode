public class Solution {

	List<List<Integer>> coms;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        coms = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        combine(new ArrayList<Integer>(), nums, 0, nums.length);

        return coms;
    }

    public void combine(ArrayList<Integer> com, int[] nums, int k, int n) {
    	if(k == n) {
    		coms.add(new ArrayList<Integer>(com));
    		return;
    	}

    	com.add(nums[k]);
    	combine(com, nums, k+1, n);

    	int j = k+1;
    	while(nums[i]!=nums[j] && j<n) {
    		j++;
    	}
    	

    	if(j != -1) {
    		com.remove(new Integer(nums[k]));
    		combine(com, nums, j, n);
    	}

    }
}