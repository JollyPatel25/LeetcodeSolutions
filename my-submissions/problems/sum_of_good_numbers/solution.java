class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        for(int i = 0 ; i < nums.length; i++)
        {
            boolean left = false, right = false;
            if(i - k < 0)
                left = true;
            if(i + k >= nums.length)
                right = true;
            if(left)
            {
                if(right)
                    sum += nums[i];
                else
                    if(nums[i] > nums[i + k])
                        sum += nums[i];
            }  
            else if(right)
            {
                if(nums[i] > nums[i - k])  
                    sum += nums[i];
            }
            else
            {
                if(nums[i] > nums[i - k] && nums[i] > nums[i + k])
                    sum += nums[i];
            }
        }
        return sum;
    }
}