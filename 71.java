
public class Solution {
    public String simplifyPath(String path) {
        
        int len = path.length();

        Stack<String> strs = new Stack<String>();

        int i = 0;

        while(i<len) {
        	if(path.charAt(i)=='/') {
        		i++;
        	} else {
        		String str = path.charAt(i)+"";
        		i++;
        		int j = i;
        		while(j<len && path.charAt(j)!='/') {
    				str = str+""+path.charAt(i);
    				j++;
        		}

        		if(str.equals("..")) {
				 	if(!strs.empty()) {
						strs.pop();
					}
				} else if(!str.equals(".")){
					strs.push(str);
				}
				i=j+1;
        	}
        }

        if(strs.empty())
        	return "/";

        String abPath = "";
        for(String str : strs) {
        	abPath = abPath+"/"+str;
        }

        return abPath;
    }
}