class Solution {
    public int divide(int dividend, int divisor) {
        boolean flag = false;
        long divid = dividend, divis = divisor, q = 0;
        if(divid < 0 && divis < 0)
        {
            divid *= -1;
            divis *= -1;
        }
        else if(divis < 0)
        {
            flag = true;
            divis *= -1;
        }
        else if(divid < 0)
        {
            flag = true;
            divid *= -1;
        }
        while (divid >= divis) {
            long temp = divis, mul = 1;
            while (divid >= (temp << 1)) {
                temp <<= 1;
                mul <<= 1;
            }
            divid -= temp;
            q += mul;
        }
        if (flag == true)
        {
            q = -q;
        }
        if(q > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        } 
        else if(q < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        else return (int)q;
    }
}