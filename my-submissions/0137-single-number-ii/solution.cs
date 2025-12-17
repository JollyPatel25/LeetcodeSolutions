public class Solution {
    public int SingleNumber(int[] nums) {
        int result = 0;
        for(int bit = 0; bit < 32; bit++)
        {
            int count = 0;
            foreach(int n in nums)
            {
                if(((n >> bit) & 1) == 1) count++;
            }
            if(count % 3 != 0) result |= (1 << bit);
        }
        return result;
    }
}
