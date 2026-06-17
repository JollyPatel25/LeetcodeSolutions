class Solution {
    public int maxScore(int[] nums) {
        int[] dp = new int[1 << nums.length];
        for(int mask = 0; mask < (1 << nums.length); mask++)
        {
            int bitCount = Integer.bitCount(mask);
            if(bitCount % 2 != 0) continue;
            int opNum = (bitCount / 2) + 1;
            for(int i = 0 ; i < nums.length; i++)
            {
                if((mask & (1 << i)) != 0) continue;
                for (int j = i + 1; j < nums.length; j++)
                {
                    int newMask = mask | (1 << i) | (1 << j);
                    if((mask & (1 << j)) != 0) continue;
                    dp[newMask] = Math.max(dp[newMask], dp[mask] + opNum * gcd(nums[i], nums[j]));
                }
            }
        }
        int fullMask = (1 << nums.length) - 1;
        return dp[fullMask];
    }
    int gcd (int a, int b)
    {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
