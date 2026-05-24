class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int jumps = 0;
        int maxReach = 0;
        int currentBoundary = 0;
        for(int i = 0; i < nums.length; i++)
        {
            maxReach = Math.max(maxReach,  (i + nums[i]));
            if(i == currentBoundary)
            {
                jumps++;
                currentBoundary = maxReach;
                if(currentBoundary >= nums.length - 1) break;
            }
        }
        return jumps;
    }
}
