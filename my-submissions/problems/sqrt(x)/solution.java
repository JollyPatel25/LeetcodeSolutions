class Solution {
    public int mySqrt(int x) {
        for(int i = 1; i <= x; i++)
        {
            if(x == 0)
            {
                return 0;
            }
            if(x == (i*i))
            {
                return i;
            }
            if(((long)(i - 1) * (i - 1)) < x && x < ((long)i * i)){
                return i - 1;
            }
        }
        return 0;
    }
}