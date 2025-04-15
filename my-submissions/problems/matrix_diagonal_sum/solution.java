class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0, k = mat.length - 1;
        for(int i = 0; i < mat.length; i++, k--)
        {
            sum += mat[i][i];
            if(i == k) continue;
            sum += mat[i][k];
        }
        return sum;
    }
}