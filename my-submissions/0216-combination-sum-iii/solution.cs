public class Solution {
    public IList<IList<int>> CombinationSum3(int k, int n) {
        IList<IList<int>> result = new List<IList<int>>();
        IList<int> current = new List<int>();
        void Backtrack(int start, int sum)
        {
            if(current.Count == k && sum == n)
            {
                result.Add(new List<int>(current));
                return;
            }
            for(int i = start; i <= 9; i++)
            {
                if(sum + i <= n)
                {
                    current.Add(i);
                    Backtrack(i + 1, sum + i);
                    current.RemoveAt(current.Count - 1);
                }
            }
        }
        Backtrack(1, 0);
        return result;
    }
}
