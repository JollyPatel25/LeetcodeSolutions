class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int even = expandFromCenter(i, i + 1, s);
            int odd = expandFromCenter(i, i, s);
            int len = Math.max(odd, even);
            if(len > end - start)
            {
                start = i - ((len - 1) / 2);
                end = (len / 2) + i;
            }
        }
        return s.substring(start , end + 1);
    }
    public int expandFromCenter(int left, int right, String s)
    {
        while(left >= 0 && right <= s.length() - 1)
        {
            if(s.charAt(left) != s.charAt(right)) break;
            else{
                right++;
                left--;
            }
        }
        return right - left - 1;
    }
}