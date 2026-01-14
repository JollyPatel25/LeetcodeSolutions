public class Solution {
    public int MinBitFlips(int start, int goal) {
        int count = 0;
        while(goal > 0 || start > 0)
        {
            if((start & 1) != (goal & 1)) count++;
            start >>= 1;
            goal >>= 1;
        }
        return count;
    }
}
