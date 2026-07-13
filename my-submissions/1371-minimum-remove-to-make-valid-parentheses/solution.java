class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++)
        {
            if (chars[i] == '(')
                stack.push(i);
            else if (chars[i] == ')')
            {
                if (!stack.isEmpty())
                {
                    stack.pop();
                }
                else{
                    chars[i] = '\0';
                }
            }
        }
        while(!stack.isEmpty())
        {
            chars[stack.pop()] = '\0';
        }

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c != '\0') {
                sb.append(c);
            }
        }

        return sb.toString();

    }
}
