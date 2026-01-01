public class Solution {
    public int XorOperation(int n, int start) {
        long sum = start, result = 0;
        for(int i = 0; i < n; i++)
        {
            result = result ^ sum ; 
            sum += 2;
        }
        return (int)result;
    }
}
