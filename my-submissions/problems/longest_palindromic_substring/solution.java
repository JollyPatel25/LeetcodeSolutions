class Solution {
    public String longestPalindrome(String s) {
        String sb = "";
        for (int i = 0; i < s.length(); i++) {
            sb = maxPal(s, i, i, sb);     
            sb = maxPal(s, i, i + 1, sb); 
        }
        return sb;
    }
    private String maxPal(String s, int left, int right, String sb) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--; 
            right++;
        }
        return (right - left - 1 > sb.length()) ? s.substring(left + 1, right) : sb;
    }
}
