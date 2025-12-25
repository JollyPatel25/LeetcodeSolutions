public class Solution {
    public bool HasAlternatingBits(int n) {
        int prev = n & 1;
        n >>= 1;
        while(n > 0)
        {
            int currBit = n & 1;
            if(prev == currBit) return false;
            prev = currBit;
            n >>= 1;
        }
        return true;
    }
}
