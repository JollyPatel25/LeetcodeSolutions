public class Solution {
    public int AbsDifference(int[] nums, int k) {
        Array.Sort(nums);
        int sum_left = 0;
        int sum_right = 0;
        for(int i = 0; i < k; i++)
        {
            sum_left += nums[i];
        }
        for(int i = nums.Length - 1; i >= nums.Length - k; i--)
        {
            sum_right += nums[i];
        }
        Console.WriteLine(sum_left + " " + sum_right);
        return sum_right - sum_left;
    }
}
