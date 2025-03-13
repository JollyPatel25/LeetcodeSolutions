class Solution {
    public int myAtoi(String s) {
        int length = s.length(), i = 0;
        long num = 0;
        boolean negative = false, num_start = false;
        while(i <= length - 1)
        {
            char c = s.charAt(i);
            if(c == ' ')
            {
                if(num_start)
                    break;
            }
            else if(c == '+')
            {
                if(num_start)
                    break;
                else
                    num_start = true;
            }
            else if(c == '-')
            {
                if(num_start)
                    break;
                else
                    num_start = true;
                negative = true;
            }
            else if(c >= 48 && c <= 57)
            {
                if(!num_start)
                    num_start = true;
                num = (num * 10) + (c - '0');
                if (!negative && num > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if (negative && -num < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
            else
                break;
            i++;
        }
        if(negative)
            num = -num;
        if(num < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if(num > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int)num;
    }
}