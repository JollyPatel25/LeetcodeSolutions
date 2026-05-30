class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int item : stones)
        {
            sum += item;
        }
        int capacity = (int)(sum / 2);

        int[][] dp = new int [stones.length + 1][capacity + 1];

        for (int i = 1; i <= stones.length; i++)
        {
            for (int j = 0; j <= capacity; j++)
            {
                if(stones[i - 1] <= j)
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - (2 * dp[stones.length][capacity]);
    }
}
