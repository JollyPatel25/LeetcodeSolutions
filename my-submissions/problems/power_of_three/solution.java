class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)
            return false;
        if(n == 1)
            return true;
        double value = (double)n / 3.0;
        if(value == Math.floor(value))
            return isPowerOfThree(n / 3);
        return false;
    }
}