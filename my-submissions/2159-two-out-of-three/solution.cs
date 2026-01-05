public class Solution {
    public IList<int> TwoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Dictionary<int, int> dict = new Dictionary<int, int>();
        foreach(int x in nums1) dict[x] = dict.GetValueOrDefault(x) | 1;
        foreach(int x in nums2) dict[x] = dict.GetValueOrDefault(x) | 2;
        foreach(int x in nums3) dict[x] = dict.GetValueOrDefault(x) | 4;
        List<int> result = new List<int>();
        foreach(var kv in dict)
        {
            if((kv.Value & (kv.Value - 1)) != 0)
                result.Add(kv.Key);
        }
        return result;
    }
}
