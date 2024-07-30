class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0)
        {
            return 0;
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(target <= nums[i])
            {
                return i;
            }
            else if(target > nums[i] && i == nums.length){
                break;
            }
        }
        return nums.length;
    }
}