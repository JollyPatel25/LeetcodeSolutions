class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Neighbor base 
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // Which nodes are reachable from pacific and atlantic ocean
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        Queue<int[]> queue = new LinkedList<>();

        // Find reachables for pacific
        for (int i = 0; i < heights.length; i++)
        {
            for (int j = 0; j < heights[i].length; j++)
            {
                if(i == 0 || j == 0) {
                    pacific[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty())
        {
            int[] indices = queue.poll();
            for (int[] d : directions)
            {
                int newRow = indices[0] + d[0];
                int newCol = indices[1] + d[1];
                if (newRow < 0 || newRow > heights.length - 1) continue;
                if (newCol < 0 || newCol > heights[0].length - 1) continue;
                if(!pacific[newRow][newCol] && heights[newRow][newCol] >= heights[indices[0]][indices[1]])
                {
                    pacific[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        // Find reachables for atlantic
        for (int i = 0; i < heights.length; i++)
        {
            for (int j = 0; j < heights[i].length; j++)
            {
                if(i == heights.length - 1 || j == heights[0].length - 1) 
                {
                    atlantic[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty())
        {
            int[] indices = queue.poll();
            for (int[] d : directions)
            {
                int newRow = indices[0] + d[0];
                int newCol = indices[1] + d[1];
                if (newRow < 0 || newRow > heights.length - 1) continue;
                if (newCol < 0 || newCol > heights[0].length - 1) continue;
                if(!atlantic[newRow][newCol] && heights[newRow][newCol] >= heights[indices[0]][indices[1]])
                {
                    atlantic[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        // Find common node reachable by both oceans
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < heights.length; i++){
            for (int j = 0; j < heights[i].length; j++)
            {
                if(pacific[i][j] && atlantic[i][j])
                {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
}
