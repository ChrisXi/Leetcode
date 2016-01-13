public class Solution {

    public boolean wordBreak(String s, Set<String> wordDict) {

        int len = s.length();
    	int[] check = new int[len+1];

        check[0] = 1;

        for(int i=1; i<=len; i++) {
            for(int j=i-1; j>=0; j--) {
                String str = s.substring(j,i);
                if(wordDict.contains(str) && check[j]==1) {
                    check[i] = 1;
                    break;
                }
            }
        }

        if(check[len] == 1)
            return true;

        return false;
    }
}