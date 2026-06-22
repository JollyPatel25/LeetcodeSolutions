class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < nums2.length; i++)
        {
           while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i])
           {
                int index = stack.pop();
                map.put(nums2[index], nums2[i]);
           }
           stack.push(i);
        }

        for(int i = 0; i < nums1.length; i++)
        {
           result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}
