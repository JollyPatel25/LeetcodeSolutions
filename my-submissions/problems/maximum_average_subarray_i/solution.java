class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0, right = k;
        int maxSum = 0, sum = 0;
        for(int i = 0; i < k; i++)
            sum += nums[i];
        maxSum = sum;
        while(right < nums.length)
        {
            sum += nums[right] - nums[left];
            maxSum = Math.max(maxSum, sum);
            left++;
            right++;
        }
        return (maxSum * 1.0) / k;
    }
}