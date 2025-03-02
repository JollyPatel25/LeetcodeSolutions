class Solution {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length(), tlen = t.length(), i = 0, j = 0;
        while(i < slen && j < tlen)
        {
            if(s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }
        if(i == slen)
            return true;
        return false;
    }
}