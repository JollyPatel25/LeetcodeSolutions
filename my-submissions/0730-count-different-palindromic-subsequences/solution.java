class Solution {
    public int countPalindromicSubsequences(String s) {
        int MOD = 1000000007;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        for (int i = 0; i < n - 1; i++) dp[i][i+1] = 2;

        for (int len = 3 ; len <= n; len++)
        {
            for (int i = 0; i <= n - len; i++)
            {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j))
                {
                    int l =  i + 1, r = j - 1;
                    while(l <= r && s.charAt(l) != s.charAt(i)) l++;
                    while(r >= l && s.charAt(r) != s.charAt(i)) r--;
                    if(l == r)
                    {
                        dp[i][j] = (int)(((long)dp[i+1][j-1] * 2 + 1) % MOD);
                    }
                    else if(l > r)
                    {
                        dp[i][j] = (int)(((long)dp[i+1][j-1] * 2 + 2) % MOD);
                    }
                    else
                    {
                        dp[i][j] = (int)(((long)dp[i+1][j-1] * 2 - dp[l+1][r-1] + MOD) % MOD);
                    }
                }
                else
                {
                    dp[i][j] = (int)(((long)dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1] + MOD) % MOD);
                }
            }
        }
        return dp[0][n - 1];
    }
}
