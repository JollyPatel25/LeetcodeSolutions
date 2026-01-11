public class Solution {
    public int CenteredSubarrays(int[] nums) {
        int[] arr = nums;
        int count = 0;
        for (int i = 0; i < arr.Length; i++) {
            int sum = 0;
            HashSet<int> seen = new HashSet<int>();
            for (int j = i; j < arr.Length; j++) {
                sum += arr[j];
                seen.Add(arr[j]);
                if (seen.Contains(sum)) {
                    count++;
                }
            }
        }
        return count;
    }
}

