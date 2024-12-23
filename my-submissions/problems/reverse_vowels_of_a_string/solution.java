class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        char arr[] = new char[s.length()];
        int indexes[] = new int[s.length()];
        int index = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char temp = s.charAt(i);
            switch(temp)
            {
                case 'a':case 'e':case 'i':case 'o':case 'u':
                    arr[index] = temp;
                    indexes[index] = i;
                    index++;
                    break;

                case 'A':case 'E':case 'I':case 'O':case 'U':
                    arr[index] = temp;
                    indexes[index] = i;
                    index++;
                    break;
            }
        }
        for(int i = index - 1, j = 0; i >= 0; i--, j++)
        {
            sb.setCharAt(indexes[i], arr[j]);
        }
        return sb.toString();
    }
}