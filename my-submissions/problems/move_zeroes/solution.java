class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length <= 1)
            return;
        int length = nums.length;
        int i = 0, j = i + 1; 
        first: while(j <= length - 1)
        {
            if(nums[i] == 0)
            {
                while(nums[j] == 0)
                {
                    if(j == length - 1)
                        break first;
                    j++;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
            j++;
            i++;
        }
    }
}