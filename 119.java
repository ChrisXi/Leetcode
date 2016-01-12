public class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        ArrayList<Integer> nums = new ArrayList<Integer>();

        if(rowIndex == 0)
        	return nums;

        nums.add(1);

        int no = 1;

        while(no <= rowIndex-1) {
			nums.add(0,0);
			for(int i=0; i<rowIndex-1; i++) {
				nums.set(i, nums.get(i)+nums.get(i+1));
			}    
        }

        return nums;
    }
}