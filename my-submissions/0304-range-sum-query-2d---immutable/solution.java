class NumMatrix {
    int matrixSum[][] = new int[201][201];
    public NumMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                matrixSum[i + 1][j + 1] = matrixSum[i][j + 1] + matrixSum[i + 1][j] - matrixSum[i][j] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrixSum[row2 + 1][col2 + 1] - matrixSum[row2 + 1][col1] - matrixSum[row1][col2 + 1] + matrixSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
