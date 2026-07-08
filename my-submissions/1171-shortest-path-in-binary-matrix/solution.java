class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // Neighbor calculation for each cell
        int[][] directions = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
        };

        int destinationRow = grid.length - 1;
        int destinationColumn = grid[0].length - 1;

        // Return early if invalid start or end
        if(grid[0][0] == 1 || grid[destinationRow][destinationColumn] == 1) return -1;

        // return if start is the end
        if (destinationRow == 0 && destinationColumn == 0) return 1;

        // Start BFS from first node of grid
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while(!queue.isEmpty())
        {
            int size = queue.size();
            while(size-- > 0)
            {
                int[] indices = queue.poll();
                for (int[] d : directions)
                {
                    int newRow = indices[0] + d[0];
                    int newCol = indices[1] + d[1];
                    if (newRow < 0 || newRow > destinationRow) continue;
                    if (newCol < 0 || newCol > destinationColumn) continue;
                    if (newRow == destinationRow && newCol == destinationColumn) return ++count;

                    if(grid[newRow][newCol] == 0)
                    {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
