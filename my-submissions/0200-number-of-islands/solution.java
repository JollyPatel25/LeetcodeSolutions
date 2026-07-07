class Solution {
    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int islands = 0;
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for(int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == 'v' || grid[i][j] == '0') continue;
                islands++;
                grid[i][j] = 'v';
                queue.offer(new int[]{i, j});
                while(!queue.isEmpty())
                {
                    int[] indices = queue.poll();
                    for (int[] d : directions)
                    {
                        int newRow = indices[0] + d[0];
                        int newCol = indices[1] + d[1];
                        if(newRow >= grid.length || newCol >= grid[0].length || newRow < 0 || newCol < 0) continue;
                        if(grid[newRow][newCol] != 'v' && grid[newRow][newCol] != '0')
                        {
                            grid[newRow][newCol] = 'v';
                            queue.offer(new int[]{newRow, newCol});
                        }
                    }
                }
            }
        }

        return islands;
    }
}
