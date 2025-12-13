public class Solution {
    public IList<IList<int>> SubsetsWithDup(int[] nums) {
        Array.Sort(nums);
        IList<IList<int>> result = new List<IList<int>>();
        IList<int> current = new List<int>();

        void backtrack(int index)
        {
            result.Add(new List<int>(current));

            for(int i = index; i < nums.Length; i++)
            {
                if(i > index && nums[i] == nums[i - 1]) continue;

                current.Add(nums[i]);
                backtrack(i + 1);
                current.RemoveAt(current.Count - 1);
            }
        }

        backtrack(0);
        return result;
    }
}
