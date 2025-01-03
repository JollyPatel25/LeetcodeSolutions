class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        int temp1 = 0, temp2 = 0, sum = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && j >= 0)
        {
            temp1 = Integer.valueOf(String.valueOf(num1.charAt(i)));
            temp2 = Integer.valueOf(String.valueOf(num2.charAt(j)));
            sum = temp1 + temp2 + carry;
            if(sum > 9)
                carry = 1;
            else
                carry = 0;
            sb.insert(0, (char)((sum % 10) + '0'));
            i--;
            j--;
        }
        while(i >= 0)
        {
            temp1 = Integer.valueOf(String.valueOf(num1.charAt(i)));
            if(carry == 1)
            {
                sum = temp1 + carry;
            }
            else
            {
                sum = temp1;
            }
            if(sum > 9)
                carry = 1;
            else
                carry = 0;
            sb.insert(0, (char)((sum % 10) + '0'));
            i--;
        }
        while(j >= 0)
        {
            temp2 = Integer.valueOf(String.valueOf(num2.charAt(j)));
            if(carry == 1)
            {
                sum = temp2 + carry;
            }
            else
            {
                sum = temp2;
            }
            if(sum > 9)
                carry = 1;
            else
                carry = 0;
            sb.insert(0, (char)((sum % 10) + '0'));
            j--;
        }
        if(carry == 1)
        {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}