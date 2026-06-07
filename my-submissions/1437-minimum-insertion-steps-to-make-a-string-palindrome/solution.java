class Solution {
    public int minInsertions(String s) {
        int m = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        int dp[][] = new int[m + 1][m + 1];
        
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if(s.charAt(i - 1) == sb.charAt(j - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return m - dp[m][m];
    }
}
