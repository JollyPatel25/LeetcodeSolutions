public class Solution {
    public int MinimumFlips(int n) {
        int flips = 0;
        int len = 0, temp = n;
        while (temp > 0) { len++; temp >>= 1; }
        for (int i = 0; i < len / 2; i++) {
            int left = (n >> i) & 1;
            int right = (n >> (len - 1 - i)) & 1;
            if (left != right) flips += 2;
        }
        return flips;
    }
}

