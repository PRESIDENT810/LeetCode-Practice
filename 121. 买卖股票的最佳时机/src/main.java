public class main {
}

class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1 || prices.length == 0) return 0;
        int min = prices[0];
        int max_profit = 0;

        for (int i=1; i<prices.length; i++){
            int profit = prices[i]-min;
            if (profit > max_profit) max_profit = profit;
            if (prices[i] < min) min = prices[i];
        }
        return max_profit;
    }
}