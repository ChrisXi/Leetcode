public class Solution {
    public int longestValidParentheses(String s) {
        
        Stack<Integer> stack = new Stack<Integer>();

        int len = s.length();
        int[] p = new int[len];

        for(int i=0; i<len; i++) {
        	if(s.charAt(i) == '(') {
        		stack.push(i);
        	} else {
        		if(stack.size() != 0) {
        			int j = stack.pop();
        			p[i] = 1;
        			p[j] = 1;
        		}
        	}
        }

        int maxLen = 0;
        for(int i=0; i<len; ) {
        	if(p[i] == 1) {
        		int start = i;
        		while(i<len && p[i]==1) {
        			i++;
        		}
        		maxLen = maxLen>(i-start) ? maxLen:(i-start);
        	} else {
        		i ++;
        	}
        }
        return maxLen;
    }
}