class Solution {
    public void reverseString(char[] s) {
        char temp;
        int i = 0, j = s.length - 1;
        while(i < j && j >= 0 && i <= s.length - 1){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}