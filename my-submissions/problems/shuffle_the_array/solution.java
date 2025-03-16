class Solution {
    public int[] shuffle(int[] nums, int n) {
        int numbers[] = new int[nums.length], j = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(i % 2 != 0)
                numbers[i] = nums[i + n - j];
            else
                numbers[i] = nums[j++];
        }
        return numbers;
    }
}