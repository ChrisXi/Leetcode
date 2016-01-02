public class Solution {

	int size;
	List<String> strs;
    public List<String> generateParenthesis(int n) {
        
        strs = new ArrayList<String>();

    	if(0 == n) {
    		strs.add("");
    		return strs;
    	}

    	this.size = n;
    	String str = "";

    	add(str, 1, 0);

    	return strs;

    }

    public void add(String str, int no, int limit) {

    	limit += 1;
    	str += "(";



    	if(no == this.size) {
    		str += addRight(limit);
    		this.strs.add(str);
    	} else {
    		for(int i=0; i<=limit; i++) {
    			String temp = str;
	    		temp += addRight(i);
	    		add(temp, no+1, limit-i);
    		}
    	}
    }

	public String addRight(int num) {
		String str = "";
		for(int i=1; i<=num; i++) {
			str += ")";
		}

		return str;
	}
}