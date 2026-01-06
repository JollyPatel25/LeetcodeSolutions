public class Solution {
    public bool HasTrailingZeros(int[] nums) {
        int count = 0;
        foreach(int i in nums){
            if((i & 1) == 0) count++;
        }
        return count >= 2;
    }
}
