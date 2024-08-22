class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0)
            return false;
        if(n == 1)
            return true;
        if(n % 2 != 0)
            return false;
        double value = (double)n / 4.0;
        if(value == Math.floor(value))
            return isPowerOfFour(n / 4);
        return false;
    }
}