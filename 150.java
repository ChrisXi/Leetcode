public class Solution {

    Stack<Integer> nums;

    public int evalRPN(String[] tokens) {
        
        int len = tokens.length;
        nums = new Stack<Integer>();

        int num = 0;
        if(checkNum(tokens[len-1])) {
    		num = Integer.valueOf(tokens[len-1]);
    	}

        for(int i=0; i<len; i++) {
        	if(checkNum(tokens[i])) {
        		nums.push(Integer.valueOf(tokens[i]));
        	} else {
        		String str = tokens[i];
        		int b = nums.pop();
        		int a = nums.pop();

        		int c = calculate(str, a, b);
        		nums.push(c);

        		num = c;
        	}
        }

        return num;
    }

    public boolean checkNum(String str) {

    	if(str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*")) {
    		return false;
    	} 

    	return true;
    }

    public int calculate(String str, int a, int b) {

    	if(str.equals("+")){
    		return a+b;
    	}else if(str.equals("-")){
    		return a-b;
    	}else if( str.equals("/")){
    		return a/b;
    	}else if(str.equals("*")) {
    		return a*b;
    	}

    	return 0;
    }

    
}



