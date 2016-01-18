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
    	

    	for(int start=0; start<slen; start++) {
    		Hashtable<String, Integer> temp = new Hashtable<String, Integer>(map);
    		for(int i=start; i<len; i += slen) {
	    		
	    		if(len-i<slen) {
	    			break;
	    		}

	    		String sub = s.substring(i, i+slen);
	    		if(temp.containsKey(sub)) {
	    			if(temp.get(sub) == 1) {
						temp.remove(sub);    				
						if(temp.size() == 0) {
							index.add(i-slen*(words.length-1));
							
							String str = s.substring(i-slen*(words.length-1), i-slen*(words.length-2));
							temp.put(str, 1);
						}
	    			} else {
	    				temp.put(sub, temp.get(sub)-1);
	    			}
	    		} else {
	    			if(map.containsKey(sub)) {
	    				temp = (Hashtable<String, Integer>) map.clone();
	    				for(int j=i-slen; j>=0; j -= slen) {
	    					String str = s.substring(j, j+slen);
	    					if(sub.equals(str)) {
	    						if(temp.get(str) == 1) {
	    							temp.remove(str);
	    							break;
	    						} else {
	    							temp.put(str, temp.get(str)-1);
	    						}
	    					} else {
	    						temp.remove(str);
	    					}
	    				}
	    			} else {
	    				temp = (Hashtable<String, Integer>) map.clone();
	    			}
	    		}
    		}
    	}

    	
        
        return index;
    }
}