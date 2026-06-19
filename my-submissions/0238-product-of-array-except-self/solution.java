class Solution {
    public int[] productExceptSelf(int[] nums) {

        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        int result[] = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;

        for (int i = 0; i < nums.length - 1; i++)
        {
            left[i + 1] = left[i] * nums[i];
        }

        for (int i = nums.length - 1; i > 0; i--)
        {
            right[i - 1] = right[i] * nums[i];
        }

        for (int i = 0; i < nums.length; i++)
        {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}
