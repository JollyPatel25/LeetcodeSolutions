public class Solution {
    public IList<IList<int>> CombinationSum2(int[] candidates, int target) {
        Array.Sort(candidates);
        var result = new List<IList<int>>();
        var current = new List<int>();

        void dfs(int start, int sum) {
            if (sum == target) {
                result.Add(new List<int>(current)); // add a copy
                return;
            }
            if (sum > target) return;

            for (int i = start; i < candidates.Length; i++) {
                // skip duplicates at the same recursion level
                if (i > start && candidates[i] == candidates[i - 1]) continue;

                int pick = candidates[i];
                if (sum + pick > target) break; // array is sorted => can prune

                current.Add(pick);
                dfs(i + 1, sum + pick); // use each candidate at most once
                current.RemoveAt(current.Count - 1);
            }
        }

        dfs(0, 0);
        return result;
    }
}

