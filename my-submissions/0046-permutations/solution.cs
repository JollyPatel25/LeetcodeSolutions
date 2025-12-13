public class Solution {
    public IList<IList<int>> Permute(int[] nums) {
        IList<IList<int>> result = new List<IList<int>>();
        IList<int> current = new List<int>();
        void backtrack(IList<int> unused, IList<int> current)
        {
            if(current.Count == nums.Length)
            {
                result.Add(new List<int>(current));
                return;
            }
            for(int i = 0; i < unused.Count; i++)
            {
                current.Add(unused[i]);
                unused.RemoveAt(i);
                backtrack(unused, current);
                unused.Insert(i, current.Last());
                current.RemoveAt(current.Count - 1);
            }
            return;
        }
        backtrack(new List<int>(nums), current);
        return result;
    }
}
