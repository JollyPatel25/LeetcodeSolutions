class Solution {
    public int pivotIndex(int[] nums) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];

        left[0] = 0;
        right[nums.length - 1] = 0;

        for (int i = 0; i < nums.length - 1; i++)
        {
            left[i + 1] +=  left[i] + nums[i];
        }
        for (int i = nums.length - 1; i > 0; i--)
        {
            right[i - 1] +=  right[i] + nums[i];
        }

        for (int i = 0; i < nums.length; i++)
        {
            if(left[i] == right[i]) return i;
        }

        return -1;
    }
}
