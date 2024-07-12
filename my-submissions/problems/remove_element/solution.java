class Solution {
    public int removeElement(int[] nums, int val) {
        int rev = nums.length - 1;
        int temp;
        int count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != val)
            {
                count++;
            }
            else if(i < rev)
            {
                while(rev > 0 && nums[rev] == val)
                {
                    rev--;
                }
                if(i < rev)
                {
                    temp = nums[i];
                    nums[i] = nums[rev];
                    nums[rev] = temp;
                    rev--;
                    count++;
                }
            }
            if(i == rev && nums[i] != val)
            {
                count = count++;
            }
        }
        return count;
    }
}