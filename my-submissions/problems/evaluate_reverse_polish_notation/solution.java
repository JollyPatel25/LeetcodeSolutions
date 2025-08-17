class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++)
        {
            if(tokens[i].equals("+"))
            {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 + num2);
            }
            else if(tokens[i].equals("-"))
            {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 - num2);               
            }
            else if(tokens[i].equals("*"))
            {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 * num2);
            }
            else if(tokens[i].equals("/"))
            {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 / num2);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}