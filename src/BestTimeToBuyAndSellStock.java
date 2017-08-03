/**
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock
*/
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int p : prices) {
            minPrice = Math.min(p, minPrice);
            maxProfit = Math.max(p - minPrice, maxProfit);    
        }
        
        return maxProfit;
    }
}
