import java.util.SortedSet;
import java.util.TreeSet;
class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        SortedSet<Integer> sortedSet = new TreeSet<>();
        for(int i = 0; i < nums.length; i++)
        {
            sortedSet.add(nums[i]);
        }
        Integer integerArr[] = sortedSet.toArray(new Integer[0]);
        for (int i = 0; i < integerArr.length; i++) {
            nums[i] = integerArr[i];
        }
        return sortedSet.size();
    }
}