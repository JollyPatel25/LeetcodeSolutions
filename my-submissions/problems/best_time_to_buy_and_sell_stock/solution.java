class Solution {
    public int maxProfit(int[] prices) {
        int max = prices[0], min = prices[0], z = 0, result = 0;
        int profit[] = new int[prices.length - 1];
        for(int k = 0 ; k < prices.length; k++)
        {
            max = prices[k];
            for(int l = k + 1; l < prices.length; l++)
            {
                if(min < prices[l])
                {
                    if(max < prices[l])
                    {
                        max = prices[l];
                    }
                }
                else
                {
                    profit[z] = max - min;
                    z++;
                    min = prices[l];
                    k = l - 1;
                    break;
                }
                if(l == prices.length - 1)
                {
                    profit[z] = max - min;
                    z++;
                }
            }
        }
        for(int k = 0; k < z; k++)
        {
            if(profit[k] > result)
                result = profit[k];
        }
        return result;
    }
}