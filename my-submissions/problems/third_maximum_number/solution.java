class Solution {
    public int thirdMax(int[] nums) {
        int count = 3, i = nums.length - 1;
        Arrays.sort(nums);
        int max = nums[nums.length - 1], last = 0;
        while(i >= 0)
        {
            if(count == 3)
            {
                last = nums[i];
                count--;
                i--;
            }
            else if(count > 0)
            {
                if(last == nums[i])
                {
                    i--;
                    continue;
                }
                else{
                    last = nums[i];
                    count--;
                    i--;
                }
            }
            else
                break;
        }
        if(count != 0)
            return max;
        return last;
    }
}