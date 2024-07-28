class Solution {
    public String addBinary(String a, String b) {
        StringBuilder num1 = new StringBuilder(a);
        StringBuilder num2 = new StringBuilder(b);
        StringBuilder answer;
        int num1Len = num1.length();
        int num2Len = num2.length();
        char carry = '0';
        if(num1Len > num2Len)
        {
            for(int i = 0; i < (num1Len - num2Len); i++)
            {
                num2.insert(0, "0", 0, 1);
            }
            num2Len = num2.length();
        }
        if(num2Len > num1Len)
        {
            for(int i = 0; i < (num2Len - num1Len); i++)
            {
                num1.insert(0, "0", 0, 1);
            }
            num1Len = num1.length();
        }
        answer = new StringBuilder();
        answer.setLength(num1Len);
        for(int i = num1Len - 1; i >= 0; i--)
        {
            char n1 = num1.charAt(i);
            char n2 = num2.charAt(i);
            if(n1 == '0' && n2 == '0')
            {
                if(carry == '1')
                answer.setCharAt(i, '1');
                else
                answer.setCharAt(i, '0');
                carry = '0';
                
            }
            if(n1 == '1' && n2 == '1')
            {
                if(carry == '1')
                    answer.setCharAt(i, '1');
                else {
                    answer.setCharAt(i, '0');
                    carry = '1';
                }
            }
            if(n1 != n2)
            {
                if(carry == '1') {
                    answer.setCharAt(i, '0');
                }
                else 
                    answer.setCharAt(i, '1');
            }
        }
        if(carry == '1')
            answer.insert(0, "1", 0, 1);
        return answer.toString();
    }
}