class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = -1;
        int length = -1;
        for (int i = 0 ; i < n; i++)
        {
            int left = i, right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right))
            {
                left--;
                right++;
            }
            int oddLength = right - left - 1;
            if(oddLength > length)
            {
                length = oddLength;
                start = left + 1; 
            }

            left = i;
            right = i + 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right))
            {
                left--;
                right++;
            }
            int evenLength = right - left - 1;
            if(evenLength > length)
            {
                length = evenLength;
                start = left + 1;
            }
        }
        return s.substring(start, start + length);
    }
}
