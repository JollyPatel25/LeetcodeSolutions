class Solution {
    public int maximumValue(String[] strs) {
     int maxLen = 0;
     for(String s: strs)
     {
        if(isNumeric(s))
        {
            maxLen = maxLen > Integer.parseInt(s) ? maxLen : Integer.parseInt(s);
        }
        else
        {
            maxLen = maxLen > s.length() ? maxLen : s.length();
        }
     }
     return maxLen;
    }
     
    public boolean isNumeric(String s)
    {
        return s != null && s.matches("\\d+");
    } 
}