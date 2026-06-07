class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for(int i = 0; i <= nums1.length; i++) dp[i][0] = Integer.MIN_VALUE / 2;
        for(int j = 0; j <= nums2.length; j++) dp[0][j] = Integer.MIN_VALUE / 2;
        for (int i = 1; i <= nums1.length; i++)
        {
            for (int j = 1; j <= nums2.length; j++)
            {
                int current =  nums1[i - 1] * nums2[j - 1];
                if(dp[i - 1][j - 1] > 0) current += dp[i - 1][j - 1];
                dp[i][j] = Math.max(
                    current,
                    Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    )
                );
            }
        }

        return dp[nums1.length][nums2.length];
    }
}
