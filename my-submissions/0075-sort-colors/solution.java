class Solution {
    public void sortColors(int[] nums) {
        int low = -1, mid = 0, high = nums.length;
        while (mid < high)
        {
            if(nums[mid] == 0)
            {
                low++;
                int temp = nums[low];
                nums[low] = 0;
                nums[mid] = temp;
                mid++;
            }
            else if(nums[mid] == 2)
            {
                high--;
                int temp = nums[high];
                nums[high] = 2;
                nums[mid] = temp;
            }
            else
            {
                mid++;
            }
        }
    }
}
