class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++)
        {
            for(int j = i + 1; j < nums.length - 2; j++)
            {
                int left = j + 1, right = nums.length - 1;
                while(left < right)
                {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target)
                    {
                        List<Integer> temp = new ArrayList<>(
                            Arrays.asList(
                                nums[i], 
                                nums[j], 
                                nums[left], 
                                nums[right]
                            )
                        );
                        if(!list.contains(temp)) 
                            list.add(temp);
                        left++;
                        right--;
                    }
                    else if(sum < target)
                        left++;
                    else
                        right--;
                }
            }
        }
        return list;
    }
}