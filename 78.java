public class Solution {

	List<List<Integer>> coms;

    public List<List<Integer>> subsets(int[] nums) {
        coms = new ArrayList<List<Integer>>();

        int len = nums.length;
        Arrays.sort(nums);


        combine(new ArrayList<Integer>(), nums, 0, len);

        return coms;
    }

    public void combine(ArrayList<Integer> com, int[] nums, int k, int n) {

    	if(k == n) {
    		coms.add(new ArrayList<Integer>(com));
    		return;
    	}

    	com.add(nums[k]);
    	combine(com, nums, k+1, n);

    	com.remove(new Integer(nums[k]));
    	combine(com, nums, k+1, n);

    }
}