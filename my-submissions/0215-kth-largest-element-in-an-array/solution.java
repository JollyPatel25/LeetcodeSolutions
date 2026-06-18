class Solution {
    public int findKthLargest(int[] nums, int k) {
        int position = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, position);
    }
    public int quickSelect(int[] nums, int start, int end, int target)
    {
        int pivotIndex = partition(nums, start, end);
        if(pivotIndex == target) return nums[pivotIndex];
        else if (pivotIndex < target) return quickSelect(nums, pivotIndex + 1, end, target);
        else return quickSelect(nums, start, pivotIndex - 1, target);
    }
    public int partition(int[] nums, int start, int end) 
    {
        int pivot = nums[end];
        int low = start - 1, high = start;

        while(high < end)
        {
            if (nums[high] < pivot)
            {
                low++;
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
            }
            high++;
        }
        low++;
        int temp = nums[low];
        nums[low] = pivot;
        nums[end] = temp;

        return low;
    }
}
