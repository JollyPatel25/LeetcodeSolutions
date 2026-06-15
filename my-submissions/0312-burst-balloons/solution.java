class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        arr[0] = 1;
        arr[nums.length + 1] = 1;
        for (int i = 1; i <= nums.length; i++) arr[i] = nums[i - 1];

        for (int len = 2; len <= nums.length + 2; len++)
        {
            for (int i = 0; i <= nums.length - len + 2; i++)
            {
                int j = i + len - 1;
                for (int k = i + 1; k < j; k++)
                dp[i][j] = Math.max(dp[i][j], dp[i][k] + arr[i] * arr[k] * arr[j] + dp[k][j]);
            }
        }

        return dp[0][nums.length + 1];
    }
}
