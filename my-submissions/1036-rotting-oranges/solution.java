class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
        for (int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == 1){
                    fresh++;
                    continue;
                }
                if(grid[i][j] == 2)
                {
                    queue.offer(new int[]{i, j});
                }

            }
        }

        if (fresh == 0) return 0;

        int minutes = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            while(size-- > 0)
            {
                int[] indices = queue.poll();
                for(int[] d : directions)
                {
                    int newRow = indices[0] + d[0];
                    int newCol = indices[1] + d[1];
                    if(newRow < 0 || newRow >= grid.length) continue;
                    if(newCol < 0 || newCol >= grid[0].length) continue;
                    if(grid[newRow][newCol] == 1)
                    {
                        grid[newRow][newCol] = 2;
                        fresh--;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            if(!queue.isEmpty())
                minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
