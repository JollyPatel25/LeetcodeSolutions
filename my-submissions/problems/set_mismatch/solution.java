class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while (i < nums.length)
        {
            int temp = nums[i] - 1;
            if(nums[i] != nums[temp])
            {
                nums[i] += nums[temp];
                nums[temp] = nums[i] - nums[temp];
                nums[i] -= nums[temp];
            }
            else
                i++;
        }
        for (int j = 0 ; j < nums.length; j++)
        {
            if(nums[j] != j + 1)
                return new int[]{nums[j], j + 1};
        }
        return new int[]{0, 0};
    }
}