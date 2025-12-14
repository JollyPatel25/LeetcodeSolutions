public class Solution {
    public IList<int> GrayCode(int n) {
        IList<int> result = new List<int>();
        for (int i = 0; i < (1 << n); i++) { //(1 << n) means 2 raised to n
            result.Add(i ^ (i >> 1)); // xor makes bits differ by 1 bit only
        }
        return result;
    }
}
