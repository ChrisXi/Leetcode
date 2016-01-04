import java.util.Hashtable;

public class Solution {

	List<List<String>> col;
	Hashtable<String, Integer> map;
	int no;
    public List<List<String>> groupAnagrams(String[] strs) {
        
        this.col = new ArrayList<List<String>>();
        this.map = new Hashtable<String, Integer>();
        int no = 0;

        for(int i=0; i<strs.length; i++) {
        	String conStr = getStr(strs[i]);
        	int index = getIndex(conStr);

        	if(index == -1) {
        		map.put(conStr, no);

        		ArrayList<String> newStrs = new ArrayList<String>();
        		newStrs.add(strs[i]);

        		col.add(newStrs);

        		no ++;
        	} else {
        		add(col.get(index), strs[i]);
        	}
        }

        return this.col;
    }

    public boolean judgeOrder(String str1, String str2) {
    	int len = str1.length();

    	for(int i=0; i<len; i++) {
    		int diff = str1.charAt(i) - str2.charAt(i);
    		if(diff > 0) {
    			return false;
    		} else if(diff == 0) {
    			continue;
    		} else {
    			return true;
    		}
    	}

    	return true;
    }

    public void add(List<String> strs, String str){

    	for(int i=0; i<strs.size(); i++){
    		if(judgeOrder(str, strs.get(i))) {
    			strs.add(i, str);
    			return;
    		}
    	}

    	strs.add(str);
    }

    public String getStr(String str) {
    	int len = str.length();
    	int[] nums = new int[len];

    	for(int i=0; i<len; i++) {
    		nums[i] = str.charAt(i)-'0';
    	}

    	Arrays.sort(nums);

    	String conStr = "";
    	for(int i=0; i<len; i++) {
    		conStr = conStr+""+nums[i];
    	}

    	return conStr;
    }

    public int getIndex(String str) {
    	
    	if(this.map.containsKey(str)) {
    		return this.map.get(str);
    	} 
    	
    	return -1;
    }
}


