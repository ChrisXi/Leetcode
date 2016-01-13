public class Solution {

    public boolean wordBreak(String s, Set<String> wordDict) {

    	return add(s, wordDict); 

    }

    public boolean add(String s, Set<String> wordDict) {

    	boolean match = false;

    	Iterator iter = wordDict.iterator();
		while(iter.hasNext()) {

			String str = (String)iter.next();

			String check = check(s, str);
			
			if(!check.equals("@@")) {

				if(check.length() == 0)
					return true;

				Set<String> temp = new HashSet<String>(wordDict);
				temp.remove(str);

				match |= add(check, temp);
			}
		}

		return match;

    }

    public String check(String s, String str) {
    	int len = str.length();

    	if(s.length() < len)
    		return "@@";

    	String temp = s.substring(0, len);

    	if(temp.equals(str)) {
    		return s.substring(len);
    	} else {
    		return "@@";  
    	}
    } 
}