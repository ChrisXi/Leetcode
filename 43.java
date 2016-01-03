public class Solution {
    public String multiply(String num1, String num2) {
        
        int len1 = num1.length();
        int len2 = num2.length();
        
        int num[] = new int[len1+len2];

        for(int i=len1-1; i>=0; i--) {
        	for(int j=len2-1; j>=0; j--) {

        		int n1 = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');

        		int index = (len1-1-i)+(len2-1-j);

        		num[index] += n1;
        	}
        }
        
        for(int i=0; i<len1+len2; i++) {
        	int digit = num[i];
        	int n =digit/10;

        	num[i] = digit%10;

        	int add = 1;

        	while(n != 0) {
        		num[i+add] += n%10;
        		n = n/10;
        		add ++;
        	}
        }

        String str = "";
        boolean start = false;
        for(int i=len1+len2-1; i>=0; i--) {

        	if(!start && num[i] == 0) {
        		continue;
        	} else {
        		start = true;
        	}

        	str = str+""+num[i];
        }

        if(str.equals("")) {
        	str = "0";
        }

        return str;
    }
}


