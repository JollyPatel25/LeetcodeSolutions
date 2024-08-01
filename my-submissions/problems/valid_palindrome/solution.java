class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s.toLowerCase());
        for(int i = 0, j = 0; i < s.length(); i++,j++)
        {
            if(!Character.isLetterOrDigit(s.charAt(i))){
                sb.delete(j, j + 1);
                j--;
            }
        }
        StringBuilder sb2 = new StringBuilder(sb.toString());
        if(sb.isEmpty())
            return true;
        sb.reverse();
        if(sb.toString().equals(sb2.toString()))
        {
            return true;
        }
        return false;
    }
}