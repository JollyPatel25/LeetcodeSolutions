public class Solution {
    public int SmallestNumber(int n) {
        int ans = 0;
        while (ans < n) {
            ans = (ans << 1) | 1;
        }
        return ans;
    }
}

