class Solution {
    public int removeDuplicates(int[] nums) {
        int unique = 0;
        int current = 1;
        while(current < nums.length)
        {
            if(nums[unique] != nums[current])
            {
                unique++;
                nums[unique] = nums[current];
            }
            current++;
        }
        return unique + 1;
    }
}