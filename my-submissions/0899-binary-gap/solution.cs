public class Solution {
    public int BinaryGap(int n) {
        int max = 0, count = -1;
        while(n > 0)
        {
            if((n & 1) == 1)
            {
                if(count == -1)
                {
                    count++;
                }
                else{
                    count++;
                    max = max > count ? max : count;
                    count = 0;
                }
            }
            else if(count != -1){
                count++;
            }
            n >>= 1;
        }
        return max;
    }
}
