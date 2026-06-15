class Solution {
    public int mctFromLeafValues(int[] arr) {
        int[][] maxLeaf = new int[arr.length][arr.length];
        int dp[][] = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++)
        {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < arr.length; i++)
            dp[i][i] = 0;

        for(int i = 0; i < arr.length; i++)
        {
            maxLeaf[i][i] = arr[i];
            for (int j = i + 1; j < arr.length; j++)
            {
                maxLeaf[i][j] = Math.max(maxLeaf[i][j - 1] , arr[j]);
            }
        }

        for (int len = 2; len <= arr.length; len++)
        {
            for (int i = 0 ; i <= arr.length - len ; i++)
            {
                int j = i + len - 1;
                for(int k = i; k < j; k++)
                {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + maxLeaf[i][k] * maxLeaf[k + 1][j] + dp[k + 1][j]);
                }
            }
        }
        return dp[0][arr.length - 1];
    }
}
