public class Solution {
    public int CountPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i = left; i <= right; i++)
        {
            if(IsPrime(CountBits(i))) count++;
        }
        return count;
    }
    private bool IsPrime(int i)
    {
        if(i < 2) return false;
        for(int j = 2; j * j <= i; j++)
        {
            if(i % j == 0) return false;
        }
        return true;
    }
    private int CountBits(int i)
    {
        int count = 0;
        while(i > 0)
        {
            count += i & 1;
            i >>= 1;
        }
        return count;
    }
}
