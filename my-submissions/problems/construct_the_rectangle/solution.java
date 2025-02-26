class Solution {
    public int[] constructRectangle(int area) {
        int data[] = {area, 1};
        int width = (int)Math.sqrt(area);
        while(width > 1)
        {
            int length = (int)area / width;
            if(length * width == area)
            {
                data[0] = length;
                data[1] = width;
                break;
            }
            width--;
        }
        return data;
    }
}