class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(!(r * c == mat.length * mat[0].length))
            return mat;
        int temp[] = new int[mat.length * mat[0].length];
        int[][] newMat = new int[r][c];
        int i = 0, j = 0, y = 0, z = 0, k = 0;
        while(i < mat.length)
        {
            j = 0;
            while(j < mat[i].length)
            {
                temp[k] = mat[i][j];
                k++;
                j++;
            }
            i++;
        }
        i = 0;
        k = 0;
        while(i < r)
        {
            j = 0;
            while(j < c)
            {
                newMat[i][j] = temp[k];
                k++;
                j++;
            }
            i++;
        }
        return newMat;
    }
}