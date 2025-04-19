class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        int degree = 0, minLength = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (!first.containsKey(num)) {
                first.put(num, i);
            }
            if (count.get(num) == degree) {
                minLength = Math.min(minLength, i - first.get(num) + 1);
            } else if (count.get(num) > degree) {
                degree = count.get(num);
                minLength = i - first.get(num) + 1;
            }
        }
        return minLength;
    }
}