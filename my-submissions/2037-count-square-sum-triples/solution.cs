public class Solution {
    public int CountTriples(int n) {
        int count = 0;
        for(int a = 1; a <= n; a++)
        {
            for(int b = 1; b <= n; b++)
            {
                int sum = (a * a) + (b * b);
                int k = (int)Math.Sqrt(sum);
                if(k <= n && k * k == sum) count++;
            }
        }
        return count;
    }
}
