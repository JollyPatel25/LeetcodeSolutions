class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int min = nums1.length > nums2.length ? nums2.length : nums1.length;
        int result_t[] = new int[min];
        boolean temp[] = new boolean[1001];
        int k = -1;
        for(int  i = 0; i < nums1.length; i++)
        {
            for(int j = 0; j < nums2.length; j++)
            {
                if(nums1[i] == nums2[j])
                {
                    if(temp[nums1[i]] == false){
                        temp[nums1[i]] = true;
                        result_t[++k] = nums1[i];
                    }
                }
            }
        }
        int result[] = new int[k + 1];
        for(int i = 0 ; i <= k; i++)
            result[i] = result_t[i];
        return result;
    }
}