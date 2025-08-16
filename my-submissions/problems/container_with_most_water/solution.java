class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int area = 0;
        while(left < right)
        {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            area = Math.max(area, w * h);
            while(left < right && height[left] <= h) left++;
            while(left < right && height[right] <= h) right--;
        }
        return area;
    }
}