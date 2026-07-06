class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int water = 0;
        int left = -1, right = -1;

        for(int i = 0; i < height.length; i++)
        {
            while(!stack.isEmpty() && height[stack.peek()] < height[i])
            {
                int current = stack.pop();
                if(!stack.isEmpty())
                {
                    left = stack.peek();
                    right = i;
                    water += (Math.min(height[right], height[left]) - height[current]) * (right - left - 1);
                }
            }
            stack.push(i);
        }

        return water;
    }
}
