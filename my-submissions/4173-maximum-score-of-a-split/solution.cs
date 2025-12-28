public class Solution {
    public long MaximumScore(int[] nums) {
        int n = nums.Length;
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--)
        {
            suffixMin[i] = Math.Min(suffixMin[i + 1], nums[i]);
        }
        long max = long.MinValue;
        long prefixSum = 0;
        for (int i = 0; i < nums.Length - 1; i++)
        {
            prefixSum += nums[i];
            long curr = prefixSum - suffixMin[i + 1];
            if(i == 0 || max < curr) max = curr;
        }
        return max;
    }
}
