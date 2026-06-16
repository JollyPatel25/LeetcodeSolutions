class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] points = new int[max + 1];
        for (int i = 0; i < nums.length; i++)
        {
            points[nums[i]] += nums[i];
        }

        int[] dp = new int[points.length];
        dp[0] = points[0];
        dp[1] = Math.max(points[0], points[1]);
        for(int i = 2; i < points.length; i++)
        {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + points[i]);
        }

        return dp[points.length - 1];
    }
}
