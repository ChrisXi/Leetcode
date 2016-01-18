import java.util.Hashtable;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

    	Hashtable<String, Integer> map = new Hashtable<String, Integer>();

    	for(int i=0; i<words.length; i++) {
    		if(map.containsKey(words[i])) {
    			map.put(words[i], map.get(words[i])+1);
    		} else {
    			map.put(words[i], 1);
    		}
    	}

    	int len = s.length();
    	int slen = words[0].length();

    	List<Integer> index = new ArrayList<Integer>();
    	
    	Hashtable<String, Integer> temp = new Hashtable<String, Integer>();
    	for(int start=0; start<slen; start++) {
    		temp.clear();
    		int count = 0;
    		for(int i=start; i<len; i += slen) {
	    		
	    		if(len-i<slen) {
	    			break;
	    		}

	    		String sub = s.substring(i, i+slen);
	    		if(map.containsKey(sub)) {
	    			if(temp.containsKey(sub)) {

	    				if(temp.get(sub)<map.get(sub)) {
	    					temp.put(sub, temp.get(sub)+1);
	    					count ++;
	    				} else {
	    					temp.clear();
	    					temp.put(str, 1);
	    					count = 1;
	    					for(int j=i-slen; j>=0; j -= slen) {
		    					String str = s.substring(j, j+slen);
		    					if(sub.equals(str)) {
		    						if(temp.get(str) == map.get(str) ) {
		    							break;
		    						} else {
		    							temp.put(str, temp.get(str)+1);
		    							count ++;
		    						}
		    					} else {
		    						temp.put(str, temp.getOrDefault(str,0)+1);
		    						count ++;
		    					}
	    					}
	    				}

	    			} else {
	    				temp.put(sub, 1);
	    				count ++;
	    			}

	    		} else {
	    			count = 0;
	    			temp.clear();
	    		}
    		}
    	}

    	
        
        return index;
    }
}