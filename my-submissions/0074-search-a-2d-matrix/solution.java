class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length * matrix[0].length - 1;
        while(low <= high)
        {
            int mid = (low + high) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;

            if(matrix[row][col] == target) return true;
            else if(target < matrix[row][col]) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}
