public class Solution {
    public int CountUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int count = 0;
        int[,] grid = new int[m, n];
        for(int i = 0; i < guards.Length; i++)
        {
            grid[guards[i][0], guards[i][1]] = 1;
        }
        for(int i = 0; i < walls.Length; i++)
        {
            grid[walls[i][0], walls[i][1]] = 2;
        }
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i, j] == 1)
                {
                    for(int y = j - 1; y >= 0; y--)
                    {
                        if(grid[i, y] == 1 || grid[i, y] == 2)
                        {
                            break;
                        }
                        grid[i, y] = 3;
                    }
                    for(int y = i - 1; y >= 0; y--)
                    {
                        if(grid[y, j] == 1 || grid[y, j] == 2)
                        {
                            break;
                        }
                        grid[y, j] = 3;
                    }
                    for(int y = i + 1; y < m; y++)
                    {
                        if(grid[y, j] == 1 || grid[y, j] == 2)
                        {
                            break;
                        }
                        grid[y, j] = 3;
                    }
                    for(int y = j + 1; y < n ; y++)
                    {
                        if(grid[i, y] == 1 || grid[i, y] == 2)
                        {
                            break;
                        }
                        grid[i, y] = 3;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i, j] == 0) count++;
            }
        }
        return count;
    }
}