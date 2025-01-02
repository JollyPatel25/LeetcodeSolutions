class Solution {
    public int hammingDistance(int x, int y) {
        int last1 = -1;
        int last2 = -1;
        int count = 0;
        while(x > 0 && y > 0)
        {
            last1 = x & 1;
            last2 = y & 1;
            if(last1 != last2)
                count++;
            x = x >> 1;
            y = y >> 1;
        }
        while(x > 0)
        {
            last1 = x & 1;
            if(last1 == 1)
                count++;
            x = x >> 1;
        }
        while(y > 0)
        {
            last2 = y & 1;
            if(last2 == 1)
                count++;
            y = y >> 1;
        }
        return count;
    }
}