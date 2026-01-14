public class Solution {
    public int[] EvenOddBit(int n) {
        int position = 0;
        int even = 0, odd = 0;
        while(n > 0)
        {
            if((n & 1) == 1)
            {
                if(position % 2 == 0) even++;
                else odd++;
            }
            position++;
            n >>= 1;
        }
        return new int[]{even, odd};
    }
}
