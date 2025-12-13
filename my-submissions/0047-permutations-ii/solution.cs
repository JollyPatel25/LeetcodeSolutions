public class Solution {
    public IList<IList<int>> PermuteUnique(int[] nums) {
        Array.Sort(nums);
        IList<int> current = new List<int>();
        List<IList<int>> result = new List<IList<int>>();
        void backtrack(IList<int> unused)
        {
            if(current.Count == nums.Length)
            {
                result.Add(new List<int>(current));
                return;
            }
            for(int i = 0; i < unused.Count; i++)
            {
                if(i > 0 && unused[i] == unused[i - 1]) continue;
                current.Add(unused[i]);
                unused.RemoveAt(i);
                backtrack(unused);
                unused.Insert(i, current.Last());
                current.RemoveAt(current.Count - 1);
            }
        }
        backtrack(new List<int>(nums));
        return result;
    }
}
