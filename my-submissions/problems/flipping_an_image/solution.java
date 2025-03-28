class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int row = image.length, col = image[0].length;
        for(int i = 0; i < row; i++)
        {
            int first = 0, last = row - 1, end = row / 2 - 1;
            while(first <= end)
            {
                image[i][first] += image[i][last]; 
                image[i][last] = image[i][first] - image[i][last];
                image[i][first] = image[i][first] - image[i][last];
                first++;
                last--;
            }
        }
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                image[i][j] = image[i][j] == 0 ? 1 : 0;
        return image;
    }
}