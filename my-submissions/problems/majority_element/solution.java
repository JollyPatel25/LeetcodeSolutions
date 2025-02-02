class Solution {
    public int majorityElement(int[] nums) {
        int count = nums.length / 2, sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i + 1; j < nums.length; j++)
            {
                if(nums[i] > nums[j])
                {
                    nums[i] = nums[i] + nums[j];
                    nums[j] = nums[i] - nums[j];
                    nums[i] = nums[i] - nums[j];
                }
            }
        }
        int num = nums[0];
        for(int i = 0; i < nums.length; i++)
        {
            if(sum > count)
                return num;
            if(num == nums[i])
                sum++;
            else
            {
                num = nums[i];
                sum = 1;
            }
        }
        return num;
    }
}