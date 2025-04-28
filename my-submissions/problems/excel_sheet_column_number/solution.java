class Solution {
    public int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int count = 0;
        for(int i = 0; i < len; i++)
        {
            count *= 26;
            count += (columnTitle.charAt(i) - 64);
        }  
        return count;
    }
}