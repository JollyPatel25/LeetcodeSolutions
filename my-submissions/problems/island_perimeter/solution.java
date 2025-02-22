class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i = 0; i < grid.length; i++)
        {
            int prev_up = 0, prev_left = 0;
            for(int j = 0; j < grid[i].length; j++)
            {
                // Identify border of island
                if(i == 0)
                    prev_up = 0;
                else
                    prev_up = grid[i - 1][j];
                if(j == 0)
                    prev_left = 0;
                else
                    prev_left = grid[i][j - 1];

                // Calculate pe rimeter
                if(prev_left + grid[i][j] == 1)
                    perimeter++;
                if(prev_up + grid[i][j] == 1)
                    perimeter++;
                if(i == grid.length - 1)
                    perimeter += grid[i][j];
                if(j == grid[i].length - 1)
                    perimeter += grid[i][j];
            }
        }
        return perimeter;
    }
}