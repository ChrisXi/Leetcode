public class Solution {
    public String addBinary(String a, String b) {
        
        int i=a.length()-1;
        int j=a.length()-1;

        int add = 0;

        String str = "";
    	while(i>=0 && j>=0) {
    		int n1 = a.charAt(i)-'0';
    		int n2 = b.charAt(j)-'0';

    		int n = (n1+n2+add)%2;

    		add = (n1+n2+add)>=2 ? 1:0;

    		str = n+""+str;

    		i--;
    		j--;
    	}

    	while(i>=0) {
    		int n1 = a.charAt(i)-'0';
    		int n = (n1+add)%2;
    		add = (n1+add)>=2 ? 1:0;
    		str = n+""+str;
    		i--;
    	}

    	while(j>=0) {
    		int n2 = b.charAt(j)-'0';
    		int n = (n2+add)%2;
    		add = (n2+add)>=2 ? 1:0;
    		str = n+""+str;
    		j--;
    	}

    	if(add == 1)
    		str = add+""+str;

    	return str;
    }
}