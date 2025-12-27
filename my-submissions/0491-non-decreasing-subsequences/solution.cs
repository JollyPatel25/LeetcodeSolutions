public class Solution {
    public IList<IList<int>> FindSubsequences(int[] nums) {
        IList<IList<int>> result = new List<IList<int>>();
        List<int> current = new List<int>();
        void backtrack(int index)
        {
            HashSet<int> set = new HashSet<int>();
            for(int i = index; i < nums.Length; i++)
            {
                if(set.Contains(nums[i])) continue;
                if(current.Count == 0 || nums[i] >= current[current.Count - 1])
                {
                    set.Add(nums[i]);
                    current.Add(nums[i]);
                        if(current.Count >= 2) result.Add(new List<int>(current));
                    backtrack(i + 1);
                    current.RemoveAt(current.Count - 1);
                }
            }
        }
        backtrack(0);
        return result;
    }
}
