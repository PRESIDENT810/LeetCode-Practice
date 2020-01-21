public class main {
}

class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1 || prices.length == 0) return 0;
        int total_profit = 0;

        for (int i=1; i<prices.length; i++){
            if (prices[i]-prices[i-1] > 0) total_profit += prices[i]-prices[i-1];
        }
        return total_profit;
    }
}
