class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int offset = 0;
        for(int item : nums) sum += item;
        if (Math.abs(target) > sum) return 0;
        offset = sum;
        int size = offset * 2 + 1;

        int[][] dp = new int[nums.length + 1][size];
        dp[0][offset] = 1;

        for(int i = 1; i <= nums.length; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if(j - nums[i - 1] >= 0)
                dp[i][j] += dp[i - 1][j - nums[i - 1]];
                if(j + nums[i - 1] < size)
                dp[i][j] += dp[i - 1][j + nums[i - 1]];
            }
        }
        return dp[nums.length][target + offset];
    }
}
