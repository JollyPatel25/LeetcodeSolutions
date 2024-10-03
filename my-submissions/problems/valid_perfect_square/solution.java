class Solution {
    public boolean isPerfectSquare(int num) {
        if(!(num % 10 == 0 || num % 10 == 1 || 
           num % 10 == 4 || num % 10 == 5 || 
           num % 10 == 6 || num % 10 == 9))
            return false;
        if(num == 1)
        {
            return true;
        }
        int low = 2, high = num / 2;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if(mid * (long)mid == (long)num)
                return true;
            if((long)num > mid * (long)mid)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}