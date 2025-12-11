public class Solution {
    public IList<IList<int>> CombinationSum(int[] candidates, int target) {
        Array.Sort(candidates);
        IList<IList<int>> result = new List<IList<int>>();
        List<int> current = new List<int>();

        void dfs(int index, int sum) {
            if (sum == target) {
                result.Add(new List<int>(current));
                return;
            }
            if (index == candidates.Length || sum > target) return;

            // Pick this number
            current.Add(candidates[index]);
            dfs(index, sum + candidates[index]);  // stay at same index
            current.RemoveAt(current.Count - 1);

            // Skip and move to next
            dfs(index + 1, sum);
        }

        dfs(0, 0);
        return result;
    }
}

