class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min = float('inf')
        maxProfit = 0
        for price in prices:
            if(price < min):
                min = price
            else:
                profit = price - min
                maxProfit = max(profit, maxProfit)
        return maxProfit