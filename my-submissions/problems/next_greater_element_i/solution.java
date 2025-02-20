class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int result[] = new int[nums1.length];
        int k = -1;
        for(int i = 0; i < nums1.length; i++)
        {
            boolean got = false, got_min = false;
            int min = nums1[i];
            for(int j = 0; j < nums2.length; j++)
            {
                if(got)
                {
                    if(nums2[j] > nums1[i])
                    {
                        got_min = true;
                        min = nums2[j];
                        break;
                    }
                }
                else if(nums1[i] == nums2[j])
                    got = true;
            }
            if(got_min)
                result[++k] = min;
            else
                result[++k] = -1;
        }
        return result;
    }
}