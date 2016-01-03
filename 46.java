import java.util.Hashtable;

public class Solution {

	Hashtable<String, Integer> numsStr;
	List<List<Integer>> comb;

    public List<List<Integer>> permute(int[] nums) {
        comb = new ArrayList<List<Integer>>();
        numsStr = new Hashtable<String, Integer>();

        List<Integer> numsCol = new ArrayList<Integer>();

        for(int i=0; i<nums.length; i++) {
        	numsCol.add(nums[i]);
        }

        for(int i=0; i<numsCol.size(); i++) {
        	ArrayList<Integer> numsLeft = new ArrayList<Integer>(numsCol);
        	numsLeft.remove(i);

        	ArrayList<Integer> numsTemp = new ArrayList<Integer>();
        	numsTemp.add(numsCol.get(i));

    		add(numsTemp, numsLeft);
    	}

		if(comb.size() == 0) 
			this.comb.add(new ArrayList<Integer>());        

        return comb;
    }

    public void add(ArrayList<Integer> numsCol, ArrayList<Integer> numsLeft) {

    	if(numsLeft.size() == 0) {
    		String str = "";
    		for(int i=0; i<numsCol.size(); i++) {
    			str = str+""+numsCol.get(i);
    		}
    		if(!this.numsStr.containsKey(str)) {
				this.comb.add(numsCol);
				this.numsStr.put(str,1);
    		}
    		return;
    	}

        for(int i=0; i<numsLeft.size(); i++) {
        	ArrayList<Integer> numsLeftTemp = new ArrayList<Integer>(numsLeft);
        	numsLeftTemp.remove(i);

        	ArrayList<Integer> numsColTemp = new ArrayList<Integer>(numsCol);
        	numsColTemp.add(numsLeft.get(i));

    		add(numsColTemp, numsLeftTemp);
    	}

    }
}


