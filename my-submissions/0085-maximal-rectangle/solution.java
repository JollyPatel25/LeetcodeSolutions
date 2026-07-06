class Solution {
    public int maximalRectangle(char[][] matrix) {
        int histogram[] = new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                histogram[j] = (matrix[i][j] == '1')
                    ? histogram[j] + 1 
                    : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleInHistogram(histogram));
        }
        return maxArea;
    }
    int largestRectangleInHistogram(int[] heights)
    {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int leftBoundary = -1, rightBoundary = -1;
        int maxArea = 0;

        for(int i = 0;i < heights.length; i++)
        {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i])
            {
                int current = stack.pop();
                if(stack.isEmpty())
                {
                    leftBoundary = -1;
                    rightBoundary = i;
                }
                else
                {
                    leftBoundary = stack.peek();
                    rightBoundary = i;
                }

                maxArea = Math.max(maxArea, heights[current] * (rightBoundary - leftBoundary - 1));
            }
            stack.push(i);
        }

        while(!stack.isEmpty())
        {
            int current = stack.pop();
            if(stack.isEmpty())
            {
                leftBoundary = -1;
                rightBoundary = heights.length;
            }
            else
            {
                leftBoundary = stack.peek();
                rightBoundary = heights.length;
            }

            maxArea = Math.max(maxArea, heights[current] * (rightBoundary - leftBoundary - 1));
        }

        return maxArea;
    }
}
