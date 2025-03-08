class Solution {
    public int[] getConcatenation(int[] nums) {
        int ans[] = new int[nums.length * 2], i = 0, j = 0;
        while(i < nums.length)
        {
            ans[i] = nums[i];
            i++;
        }
        while(i < nums.length * 2)
        {
            ans[i++] = nums[j++];
        }
        return ans;
    }
}