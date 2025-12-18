public class Solution {
    public int FindTargetSumWays(int[] nums, int target) {
        int count = 0, sum = 0;
        void backtrack(int index)
        {
            if(index == nums.Length)
            {
                if(sum == target) count++;
                return;
            }
            sum += -nums[index];
            backtrack(index + 1);
            sum -= -nums[index];
            sum += nums[index];
            backtrack(index + 1);
            sum -= nums[index];

        }
        backtrack(0);
        return count;
    }
}
