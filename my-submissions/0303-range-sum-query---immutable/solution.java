class NumArray {
    int[] prefixSum = new int[100001];
    public NumArray(int[] nums) {
        for (int i = 0 ; i < nums.length; i++)
        {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
