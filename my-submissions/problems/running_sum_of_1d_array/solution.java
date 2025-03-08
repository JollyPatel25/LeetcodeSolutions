class Solution {
    public int[] runningSum(int[] nums) {
        int runSum[] = new int[nums.length],prev = 0;
        for(int i = 0 ; i < nums.length; i++)
        {
            runSum[i] += prev + nums[i];
            prev  = runSum[i];
        }
        return runSum;
    }
}