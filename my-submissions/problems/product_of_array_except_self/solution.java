class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productLeft = new int[nums.length];
        int[] result = new int[nums.length];
        productLeft[0] = 1;
        for(int i = 1; i < nums.length; i++)
        {
            productLeft[i] = productLeft[i - 1] * nums[i - 1];
        }
        int rightProduct = 1;
        for(int i = nums.length - 1; i >= 0; i--)
        {
            result[i] = productLeft[i] * rightProduct;
            rightProduct *= nums[i]; 
        }
        return result;
    }
}