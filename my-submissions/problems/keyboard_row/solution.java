class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        ArrayList<String> arr = new ArrayList<String>();
        int row = -1, row_temp = -1;
        for(int i = 0; i < words.length; i++)
        {
            for(int j = 0; j < words[i].length(); j++)
            {
                char temp = Character.toLowerCase(words[i].charAt(j));
                if(row1.indexOf(temp) != -1)
                    row_temp = 0;
                if(row2.indexOf(temp) != -1)
                    row_temp = 1;
                if(row3.indexOf(temp) != -1)
                    row_temp = 2;
                if(j == 0)
                {
                    row = row_temp;
                }
                else
                {
                    if(row_temp != row)
                    {
                        break;
                    }
                }
                if(j == words[i].length()  - 1)
                {
                    arr.add(words[i]);
                }
            }
        }
        String[] array = arr.toArray(new String[0]);
        return array;
    }
}