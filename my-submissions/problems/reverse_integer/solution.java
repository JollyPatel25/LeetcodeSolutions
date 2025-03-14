class Solution {
    public int reverse(int x) {
        int num = 0;
        boolean negative = false;
        if(x < 0)
        {
            negative = true;
            if(x == Integer.MIN_VALUE) 
                return 0;
            x = -x;
        }
        while(x > 0) {
            int last = x % 10;
            if(num > (Integer.MAX_VALUE - last) / 10) 
                return 0;
            num = num * 10 + last;
            x /= 10;
        } 
        if(negative)
            num = -num;
        return num;
    }
}