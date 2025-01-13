class Solution {
    public int countSegments(String s) {
        int count = 0;
        boolean flag = false;
        String specialChars = "!@#$%^&*()_+-=',.:";
        for(int i = 0; i <= s.length() - 1; i++)
        {
            char ch = s.charAt(i);
            if((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) || 
            (ch >= 48 && ch <= 57) || specialChars.indexOf(ch) != -1){
                if(flag == false)
                {
                    flag = true;
                    count++;
                }
                else
                    continue;
            }
            else if(ch == ' ' && flag == true)
                flag = false;
        }
        return count;
    }
}