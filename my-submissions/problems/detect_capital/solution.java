class Solution {
    public boolean detectCapitalUse(String word) {
        boolean first = false, rest_small = true, rest_cap = true;
        for(int i = 0; i < word.length(); i++)
        {
            if(i == 0)
                first |= isCap(word.charAt(i));
            else
            {
                rest_cap &= isCap(word.charAt(i));
                rest_small &= !isCap(word.charAt(i));
            }
        }
        if(first)
        {
            if(rest_cap || rest_small)
                return true;
            else
                return false;
        }
        if(rest_small)
            return true;
        return false;
    }
    public static boolean isCap(char c)
    {
        if(c >= 65 && c <= 90)
            return true;
        return false;
    }
}