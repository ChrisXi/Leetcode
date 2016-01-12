public class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> nums = new ArrayList<List<Integer>>();

        if(numRows == 0)
        	return nums;

        ArrayList<Integer> num = new ArrayList<Integer>();
        num.add(1);
        nums.add(num);

        if(numRows == 1) {
        	return nums;
        }

        int no = 1;
        while(no <= numRows-1) {

        	ArrayList<Integer> pre = new ArrayList<Integer>(nums.get(no-1));
        	ArrayList<Integer> temp = new ArrayList<Integer>();

        	pre.add(0,0);
        	pre.add(0);

        	for(int i=0; i<=no; i++) {
        		temp.add(pre.get(i)+pre.get(i+1));
        	}

        	nums.add(temp);

        	no++;
        }

        return nums;
    }
}