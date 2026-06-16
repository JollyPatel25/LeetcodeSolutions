class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, -prices[0]);

        for (int i = 1; i < prices.length; i++)
        {
            for (int t = 1; t <= k; t++)
            {
                buy[t] = Math.max(buy[t], sell[t - 1]  - prices[i]);
                sell[t]= Math.max(sell[t], buy[t] + prices[i]);
            }
        }

        return sell[k];
    }
}
