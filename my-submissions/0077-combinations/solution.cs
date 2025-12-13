public class Solution {
    public IList<IList<int>> Combine(int n, int k) {
        IList<IList<int>> result = new List<IList<int>>();
        IList<int> current = new List<int>();
        void backtrack(int start)
        {
            if(current.Count == k)
            {
                result.Add(new List<int>(current));
                return;
            }
            for(int i = start; i <= n; i++)
            {
                current.Add(i);
                backtrack(i + 1);
                current.RemoveAt(current.Count - 1);
            }
            return;
        }
        backtrack(1);
        return result;
    }
}
