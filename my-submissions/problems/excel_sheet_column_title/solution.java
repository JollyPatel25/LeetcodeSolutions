class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb =  new StringBuilder();
        while(columnNumber > 0)
        {
            if(columnNumber % 26 == 0)
            {
                sb.insert(0 , 'Z');
                columnNumber = (int)columnNumber / 26 - 1;
            }
            else
            {
                char s = (char)((columnNumber % 26) + 64);
                sb.insert(0, s);
                columnNumber = (int)columnNumber / 26;
            }
        }
        return sb.toString();
    }
}