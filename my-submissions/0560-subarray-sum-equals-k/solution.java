class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int prefixSum = 0, count = 0;
        map.put(0, 1);
        for (int num : nums)
        {
            prefixSum += num;
            Integer previousPrefixSum = prefixSum - k;
            count += map.getOrDefault(previousPrefixSum, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
