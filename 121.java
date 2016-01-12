public class Solution {
    public int maxProfit(int[] prices) {
        
       int len = prices.length;

       int maxProfit = 0;
       int minPrice = -1;

       for(int i=0; i<len; i++) {
       		if(minPrice == -1 || prices[i] < minPrice) {
       			minPrice = prices[i];
       		} else {

       			if(prices[i]-minPrice > maxProfit) {
       				maxProfit = prices[i]-minPrice;
       			}
       		}
       }

       return maxProfit;
    }
}