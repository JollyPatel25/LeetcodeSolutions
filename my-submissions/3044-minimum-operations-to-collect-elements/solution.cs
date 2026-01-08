public class Solution {
    public int MinOperations(IList<int> nums, int k) {
        bool[] seen = new bool[k + 1];
        int found = 0, ops = 0;

        for (int i = nums.Count - 1; i >= 0; i--)
        {
            ops++;
            int val = nums[i];

            if (val <= k && !seen[val])
            {
                seen[val] = true;
                found++;
                if (found == k)
                    return ops;
            }
        }
        return ops;      
    }
}
