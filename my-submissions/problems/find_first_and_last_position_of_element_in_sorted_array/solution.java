class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1, -1};
        int low = 0, high = nums.length - 1;
        while(low <= high)
        {
            if((low == high || high <= low) && nums[low] != target)
                return new int[]{-1,-1};
            if(nums[low] < target)
                low++;
            if(nums[high] > target)
                high--;
            if(nums[low] == target && target == nums[high])
                break;
        }
        if((low == high || high <= low) && nums[low] != target)
            return new int[]{-1,-1};
        return new int[]{low, high};
    }
}