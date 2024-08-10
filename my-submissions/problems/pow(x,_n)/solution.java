class Solution {
    public double myPow(double x, int n) {
        if(x == 1 || n == 0) 
        {
            return 1;
        }
        if(x == -1)
        {
            if(n % 2 != 0)
            {
                return -1;
            }
            else{
                return 1;
            }
        }
        return Power(x, n);
    }
    public double Power(double x, int n)
    {
        double value;
        boolean flag = false,flag2 = false;
        try {
           if(n == 0)
            return 1;
            if(n == 2)
            {
                return x * x;
            }
            if(n == 3)
            {
                return x * x * x;
            }
            if(n == -3)
            {
                return 1/(x * x * x);
            }
            if(n == 1)
            {
                return x;
            }
            if(n < 0){
                flag2 = true;
                n = -n;
            }
            if(n % 2 != 0)
            {
                flag = true;
                n--;
            }
            value = Power(x, n / 2);
            value = value * value;
            if(flag == true)
            {
                value = value * x;
            }
            if(flag2 == true)
            {
                value = 1 / value;
            }
        } catch (NumberFormatException e) {
            value = 0;
        }
        if(value == Double.NEGATIVE_INFINITY || value == Double.POSITIVE_INFINITY)
        {
            return 0;
        }
        return value;
    }
}