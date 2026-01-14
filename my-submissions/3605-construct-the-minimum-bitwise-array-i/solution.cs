public class Solution {
    public int[] MinBitwiseArray(IList<int> nums) {
        int[] arr = new int[nums.Count];
        for (int i = 0; i < nums.Count; i++) {
            int x = nums[i];
            if ((x & 1) == 0) {
                arr[i] = -1;
                continue;
            }
            int res = -1;
            for (int k = 0; k < 31; k++) {
                if (((x >> k) & 1) == 1 && ((x >> (k + 1)) & 1) == 0) {
                    res = x - (1 << k);
                    break;
                }
            }
            arr[i] = res;
        }
        return arr;
    }
}
