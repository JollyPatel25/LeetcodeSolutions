class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean dp[] = new boolean[1 << nums.length];
        int maskSum[] = new int[1 << nums.length];
        dp[0] = true;
        int sum = 0, target = 0;
        
        for (int item : nums) sum += item;
        if(sum % k != 0) return false;
        target = sum / k;
        for (int num : nums) if (num > target) return false;

        for (int mask = 0; mask < (1 << nums.length); mask++)
        {
            if(!dp[mask]) continue;
            for(int i = 0; i < nums.length; i++)
            {
                if((mask & (1 << i)) != 0) continue;
                int newMask = mask | (1 << i);
                if(dp[newMask]) continue;
                if(maskSum[mask] % target + nums[i] <= target)
                {
                    maskSum[newMask] = maskSum[mask] + nums[i];
                    dp[newMask] = true;
                }
            }
        }

        return dp[(1 << nums.length) - 1];
    }
}
