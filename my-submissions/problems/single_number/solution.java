import java.util.Arrays;
class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 1)
        {
            return nums[0];
        }
        Arrays.sort(nums);
        int number = nums[0],count = 1;
        for(int i = 1; i < nums.length; i++)
        {
            System.out.println(nums[i] + " " + number);
            if(number == nums[i])
            {
                count++;
            }
            else
            {
                if(count == 1)
                {
                    return number;
                }
                count = 1;
                number = nums[i];
            }
        }
        return number;
    }
}