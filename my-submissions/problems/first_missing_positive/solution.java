class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        boolean newArr[] = new boolean[length + 1];
        newArr[0] = true;
        for(int i = 0; i < length; i++)
        {
            if(nums[i] <= 0 || nums[i] > length)
                continue;
            newArr[nums[i]] = true;
        }
        for(int i = 0; i <= length; i++)
        {
            if(i == length)
            {
                if(newArr[i] == false)
                    return i;
                else 
                    return i + 1;
            }
            if(newArr[i] == false)
                return i;
        }
        return length + 1;
    }
}