class Solution {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<Integer>();
        int sqrt = (int)Math.sqrt(n);

        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= sqrt; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if(i * i <= j && dp[(j - (i * i))] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - (i * i)] + 1);
            }
        }

        return dp[n];
    }
}
