class Solution {
    public boolean isPalindrome(int x) {
        String sb1 = Integer.toString(x);
        StringBuffer sb2 =  new StringBuffer(sb1);
        sb2.reverse();
        if(sb1.equals(sb2.toString())){
            return true;
        }
        return false;
    }
}