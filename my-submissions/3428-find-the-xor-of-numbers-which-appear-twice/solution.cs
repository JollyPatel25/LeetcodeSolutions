public class Solution {
    public int DuplicateNumbersXOR(int[] nums) {
        int result = 0;
        HashSet<int> set = new HashSet<int>();
        foreach (int num in nums) {
            if (set.Contains(num)) {
                result ^= num; 
            } else {
                set.Add(num); 
            }
        }
        return result;
    }
}

