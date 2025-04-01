class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int y = i + 1, z = nums.length - 1;
            while(y < z)
            {
                int sum = nums[i] + nums[y] + nums[z];
                if(sum == 0)
                {
                    List<Integer> newList = Arrays.asList(nums[i], nums[y], nums[z]);
                    list.add(new ArrayList<>(newList));
                    while (y < z && nums[y] == nums[y + 1]) y++;
                    while (y < z && nums[z] == nums[z - 1]) z--;
                    y++;
                    z--;
                }
                else if(sum < 0)
                    y++;
                else
                    z--;
            }
        }
        return list;
    }
}