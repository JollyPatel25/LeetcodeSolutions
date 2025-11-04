public class Solution {
    public int[] FindXSum(int[] nums, int k, int x) {
        int[] result = new int[nums.Length - k + 1];
        for(int i = 0; i < nums.Length - k + 1; i++)
        {
            int sum = 0;
            Dictionary<int, int> dict = new Dictionary<int , int>();
            for(int j = 0; j < k; j++)
            {
                int num = nums[i + j];
                dict[num] = dict.GetValueOrDefault(num, 0) + 1;
            }
            var kvps = dict.OrderByDescending(p => p.Value).ThenByDescending(p => p.Key).Take(x);
            foreach(var kvp in kvps)
            {
                sum += kvp.Key * kvp.Value;
            }
            result[i] = sum;
        }
        return result;
    }
}