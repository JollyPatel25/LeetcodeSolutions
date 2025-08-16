class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        while(left < nums.length)
        {
            if(map.containsKey(nums[left]))
            {
                if(Math.abs(map.get(nums[left]) - left) <= k){
                    return true;
                }
            }
            map.put(nums[left], left);
            left++;
        } 
        return false;
    }
}