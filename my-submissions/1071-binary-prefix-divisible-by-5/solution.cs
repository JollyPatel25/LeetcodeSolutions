public class Solution {
    public IList<bool> PrefixesDivBy5(int[] nums) {
        IList<bool> list = new List<bool>();
        int rem = 0;
        for (int i = 0; i < nums.Length; i++)
        {
            rem = (rem * 2 + nums[i]) % 5;
            list.Add(rem == 0);
        }
        return list;
    }
}
