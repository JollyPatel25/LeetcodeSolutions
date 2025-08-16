class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb  =new StringBuilder();
        int i = 0;
        while(i < s.length())
        {
            char ch = s.charAt(i);
            if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
            {
                sb.append(ch);
            }
            i++;
        }
        System.out.println(sb);
        int left = 0, right = sb.length() - 1;
        while(left < right)
        {
            if(sb.charAt(left) != sb.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}