public class Solution {
    public int SubsetXORSum(int[] nums) {
        int orValue = 0;

        foreach (int x in nums)
            orValue |= x;

        return orValue * (1 << (nums.Length - 1));
    }
}

