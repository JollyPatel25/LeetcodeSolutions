public class Solution {
    public int EvenNumberBitwiseORs(int[] nums) {
        int or = 0;
        foreach (int i in nums)
        {
            if((i & 1) == 0) or |= i;
        }
        return or;
    }
}
