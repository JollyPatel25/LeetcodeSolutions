class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length == 0)
            return m * n;
        int min_x = ops[0][0], min_y = ops[0][1];
        for(int i = 0; i < ops.length; i++)
        {
            min_x = ops[i][0] < min_x ? ops[i][0] : min_x;
            min_y = ops[i][1] < min_y ? ops[i][1] : min_y;
        }
        return min_x * min_y;
    }
}