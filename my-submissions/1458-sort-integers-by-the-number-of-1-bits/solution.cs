public class Solution {
    public int[] SortByBits(int[] arr) {
        Array.Sort(arr, (a, b) => {
            int bitsA = CountBits(a);
            int bitsB = CountBits(b);
            if(bitsA != bitsB) return bitsA - bitsB;
            return a - b;
        });
        return arr;
    }
    private int CountBits(int i){
        int count = 0;
        while(i > 0)
        {
            count += (i & 1);
            i >>= 1;
        }
        return count;
    }
}
