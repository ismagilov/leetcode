/**
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/tabs/description
*/
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        
        int pocket = 0;
        boolean bought = false;
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {           
            if (prices[i] < prices[i + 1] && bought == false) {
                pocket = prices[i];
                bought = true;
            } else if (prices[i] > prices[i + 1] && bought == true) {
                profit += prices[i] - pocket;
                bought = false;
            }
        }
        
        if (bought == true)
            profit += prices[prices.length - 1] - pocket;
        
        return profit;
    }
}
