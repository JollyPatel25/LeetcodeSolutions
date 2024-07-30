class Solution {
    public int lengthOfLastWord(String s) {
        boolean flag = false;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--)
        {
            if(s.charAt(i) != ' ' && flag == false)
            {
                flag = true;
            }
            if(s.charAt(i) == ' ')
            {
                if(flag != false)
                    return count;
                else
                    continue;
            }
            if(i == 0)
            {
                return ++count;
            }
            count++;
        }
        return 0;
    }
}