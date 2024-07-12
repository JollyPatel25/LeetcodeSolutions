import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> sc = new Stack<Character>();
        StringBuffer sb = new StringBuffer(s);
        for(int i = 0; i < sb.length(); i++)
        {
            switch(sb.charAt(i))
            {
                case '(':
                    sc.push('(');
                    break;
                case ')':
                    if(sc.isEmpty() || sc.pop() != '(')
                    {
                        return false;
                    }
                    break;
                case '{':
                    sc.push('{');
                    break;
                case '}':
                    if(sc.isEmpty() || sc.pop() != '{')
                    {
                        return false;
                    }
                    break;
                case '[':
                    sc.push('[');
                    break;
                case ']':
                    if(sc.isEmpty() || sc.pop() != '[')
                    {
                        return false;
                    }
                    break;
            }
        }
        if(sc.isEmpty())
        {
            return true;
        }
        return false;
    }
}