class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int maxArea = 0;
        int leftBoundary = -1, rightBoundary = -1;
        for (int i = 0 ; i < heights.length; i++)
        {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i])
            {
                int current = stack.pop();
                if (stack.isEmpty())
                {
                    leftBoundary = -1;
                    rightBoundary = i;
                }
                else{
                    leftBoundary = stack.peek();
                    rightBoundary = i;
                }
                int newArea = heights[current] * (rightBoundary - leftBoundary - 1);
                maxArea = Math.max(maxArea, newArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty())
        {
            int current = stack.pop();
            if(stack.isEmpty())
            {
                leftBoundary = -1;
                rightBoundary = heights.length; 
            }
            else{
                leftBoundary = stack.peek();
                rightBoundary = heights.length;
            }
            int newArea = heights[current] * (rightBoundary - leftBoundary - 1);
            maxArea = Math.max(maxArea, newArea);
        }
        return maxArea;
    }
}
