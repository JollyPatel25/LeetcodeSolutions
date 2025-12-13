public class Solution {
    public IList<IList<int>> Subsets(int[] nums) {
        IList<IList<int>> result = new List<IList<int>>();
        IList<int> current = new List<int>();

        void backtrack(int index)
        {
            if(index == nums.Length)
            {
                result.Add(new List<int>(current));
                return;
            }

            current.Add(nums[index]);
            backtrack(index + 1);
            current.RemoveAt(current.Count - 1);
            backtrack(index + 1);
        }

        backtrack(0);
        return result;
    }
}
