class Solution {
    public int[] plusOne(int[] digits) {
                int newDigits[];
        int count = 0;
        for(int i = digits.length - 1; i >= 0; i--)
        {
            if(i == 0 && digits[0] == 9)
            {
                count = digits.length + 1;
            }
            if(digits[i] != 9)
            {
                digits[i]++;
                break;
            }
            else{
                digits[i] = 0;
                continue;
            }
        }
        if(count > digits.length)
        {
            newDigits = new int[count];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }
        return digits;
    }
}