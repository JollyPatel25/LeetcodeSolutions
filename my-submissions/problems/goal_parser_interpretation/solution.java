class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < command.length(); i++)
        {
            char c = command.charAt(i);
            if(c == 'G')
            {
                sb.append("G");
            }
            else if(c == '(')
            {
                if(command.charAt(i + 1) != ')')
                {
                    sb.append("al");
                    i += 3;
                }
                else
                {
                    sb.append("o");
                    i += 1;
                }
            }
        }
        return sb.toString();
    }
}