class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int length = strs[0].length(), index = 0;
        for(int i = 0; i < strs.length; i++)
        {
            if(strs[i].length() < length)
            {
                index = i;
                length = strs[i].length();
            }
        }
        // System.out.println("index: " + index + " length: " + length);
        first: for(int i = 0; i < length; i++)
        {
            second: for(int j = 0; j < strs.length; j++)
            {
                if(strs[index].charAt(i) != strs[j].charAt(i))
                {
                    break first;
                }
            }
            sb.append(strs[index].charAt(i));
        }
        return sb.toString();
    }
}