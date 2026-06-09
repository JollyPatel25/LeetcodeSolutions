class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];
        for (int i = 0 ; i < n; i++) palindrome[i][i] = true;
        for (int i = 0 ; i < n - 1; i++) palindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);

        for(int len = 3; len <= n; len++)
        {
            for(int i = 0; i <= n - len ; i++)
            {
                int j = i + len - 1;
                palindrome[i][j] = (s.charAt(i) == s.charAt(j) && palindrome[i + 1][j - 1]);
            }
        }

        int[] dp = new int[n];
        for(int i = 0 ; i < n; i++) dp[i] = i;
        for (int i = 0; i < n; i++)
        {
            for(int j = 0; j <= i; j++)
            {
                if(j == 0 && palindrome[0][i])
                    dp[i] = 0;
                else if(palindrome[j][i])
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
            }
        }
       return dp[n - 1];
    }
}
