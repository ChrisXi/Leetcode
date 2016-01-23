public class Solution {

	List<List<Integer>> numsCom;

    public List<List<Integer>> combine(int n, int k) {
        
        numsCom = new ArrayList<List<Integer>>();

        ArrayList<Integer> nums = new ArrayList<Integer>();
        ArrayList<Integer> remain = new ArrayList<Integer>();
        for(int i=1; i<=n; i++) {
        	remain.add(i);
        }

        add(nums, remain, k);

        return numsCom;
    }

    public void add(ArrayList<Integer> nums, ArrayList<Integer> remain, int k) {

    	if(k == 0) {
    		numsCom.add(new ArrayList<Integer>(nums));
    		return;
    	}

        int len = remain.size();
    	for(int i=0; i<len; i++) {
   
    		int n = remain.get(i);

    		if(nums.size() != 0 && n < nums.get(nums.size()-1)) {
    			continue;
    		}

    		nums.add(n);
    		remain.remove(new Integer(n));

    		add(nums, remain, k-1);

    		remain.add(i,n);
    		nums.remove(new Integer(n));

    	}
    }
}