class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, sum =  0;
        for(int i = 0; i < nums.length; i++)
        {
            int left = i + 1, right = nums.length - 1;
            while(left < right)
            {
                int temp = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - temp) <= min)
                {
                    min = Math.abs(target - temp);
                    sum = temp;
                }
                if(temp < target)
                    left++;
                else
                    right--;
            }
        }
        return sum; 
    }
}