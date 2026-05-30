class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++)
        {
            for (int j = 0; j <= m; j++)
            {
                for(int k = 0; k <= n; k++)
                {
                    int[] data = count01(strs[i - 1]);
                    int zeros = data[0];
                    int ones = data[1];
                    if(zeros <= j && ones <= k && (j - zeros) >= 0 && (k - ones) >= 0)
                    {
                        dp[i][j][k] = Math.max(dp[i - 1][j - zeros][k - ones] + 1, dp[i - 1][j][k]);
                    }
                    else{
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
    public static int[] count01(String s)
    {
        int result[] = new int[2];
        int countZero = 0, countOne = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '0') countZero++;
            else countOne++;
        }
        result[0] = countZero;
        result[1] = countOne;
        return result;
    }
}
