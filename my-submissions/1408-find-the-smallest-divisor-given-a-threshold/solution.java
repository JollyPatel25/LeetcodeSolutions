class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = Arrays.stream(nums).max().getAsInt();

        while (min < max)
        {
            int mid = min + (max - min) / 2;
            int sum = 0;
            for (int i = 0; i < nums.length; i++)
            {
                sum += (nums[i] + mid  - 1 )/ mid;
            }
            if (sum <= threshold) max = mid;
            else min = mid + 1;
        }

        return min;
    }
}
