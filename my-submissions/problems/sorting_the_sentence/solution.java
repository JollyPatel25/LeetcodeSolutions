class Solution {
    public String sortSentence(String s) {
        String arr[] = new String[10];
        int length = s.length(), maxIndex = 0, currIndex = 0, i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < length)
        {
            char ch = s.charAt(i);
            if(ch == ' ' && i != 0)
            {
                arr[currIndex] = sb.toString();
                sb.setLength(0);
            }
            else if((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122))
            {
                sb.append(ch);
            }
            else if(ch >= 49 && ch <= 57)
            {
                currIndex = ch - 49;
                if(maxIndex < currIndex)
                    maxIndex = currIndex;
            }
            i++;
        }
        arr[currIndex] = sb.toString();
        sb = new StringBuilder();
        for(i = 0; i <= maxIndex; i++)
        {
            if(arr[i] != null)
                sb.append(arr[i]);
            if(i != maxIndex)
                sb.append(" ");
        }
        return sb.toString();
    }
}