public class Solution {
    public int SumIndicesWithKSetBits(IList<int> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.Count; i++)
        {
            sum += (BitOperations.PopCount((uint)i) == k) ? nums[i] : 0;
        }
        return sum;
    }
}
