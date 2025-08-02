class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int row1 = 0, row2 = matrix.length - 1, col1 = 0, col2 = matrix[0].length - 1;
        while(row1 <= row2 && col1 <= col2)
        {
            for(int j = col1; j <= col2; j++)
            {
                list.add(matrix[row1][j]);
            }
            for(int j = row1 + 1; j <= row2; j++)
            {
                list.add(matrix[j][col2]);
            }
            if(row1 < row2){
                for(int j = col2 - 1; j >= col1; j--)
                {
                    list.add(matrix[row2][j]);
                }
            }

            if(col1 < col2)
            {
                for(int j = row2 - 1; j > row1; j--)
                {
                    list.add(matrix[j][col1]);
                }
            }
            row1++;
            col1++;
            row2--;
            col2--;
        }
        return list;
    }
}