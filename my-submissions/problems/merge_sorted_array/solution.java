class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m + n == 1)
        {
            if(m == 0)
                nums1[0] = nums2[0];
        }
        else
        {
            first: for(int i = 0, j = 0; i < m + n && j < n; i++)
            {
                if(nums1[i] >= nums2[j])
                {
                    int element = m + j;
                   while(element != i)
                    {
                        nums1[element] = nums1[element - 1];
                        element--;
                    }
                    nums1[i] = nums2[j];
                    j++;
                }
                if(i == m + j)
                {
                    while(i <= m + n)
                    {
                        nums1[i] = nums2[j];
                        i++;
                        j++;
                        if(i == m + n)
                        {
                            break first;
                        }
                    }
                }    
            }
        }
    }
}