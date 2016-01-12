public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;

        int minPrice = -1;

        int maxProfit = 0;
        int tempMax = 0;

        for(int i=0; i<len; i++) {

        	if(i>0 && prices[i] < prices[i-1]) {
    			minPrice = prices[i];

    			maxProfit += tempMax;
    			tempMax = 0;
    		} else {

    			if(minPrice == -1 || prices[i] <= minPrice) {
        			minPrice = prices[i];
        		} else if(prices[i]-minPrice > tempMax) {
        			tempMax = prices[i]-minPrice;
        		}
    		}
        }
		maxProfit += tempMax;

        return maxProfit;


    }
}