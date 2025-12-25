public class Solution {
    public bool CanPartitionKSubsets(int[] nums, int k) {
        bool[] visited = new bool[nums.Length];
        bool result = false;
        int targetSum = 0;
        foreach(int i in nums) targetSum += i;
        if(targetSum % k == 0) targetSum /= k;
        else return false;
        Array.Sort(nums);
        Array.Reverse(nums);
        if (nums[0] > targetSum) return false;
        bool backtrack(int start, int currSum, int remainingSets)
        {
            if(remainingSets == 0) return true;
            if(currSum == targetSum) return backtrack(0, 0, remainingSets - 1);
            for(int j = start; j < nums.Length; j++)
            {
                if(visited[j] || currSum + nums[j] > targetSum) continue;
                visited[j] = true;
                if(backtrack(j + 1, currSum + nums[j], remainingSets))
                {
                    return true;
                }
                visited[j] = false;
                if(currSum == 0) break;
            }
            return false;
        }
        return backtrack(0, 0, k);
    }
}
