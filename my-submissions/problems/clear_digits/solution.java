class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++)
        {
            switch(sb.charAt(i))
            {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if(i == 0)
                    {
                        sb = sb.delete(i, i + 1);
                        i -= 1;
                    }
                    else{
                        sb = sb.delete(i - 1, i + 1);
                        i -= 2;
                    }    
                    break;
            }
        }
        return sb.toString();
    }
}