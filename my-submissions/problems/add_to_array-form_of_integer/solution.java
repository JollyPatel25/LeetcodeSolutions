class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<Integer>();
        int carry = 0, i = num.length - 1;
        while (i >= 0 && k > 0)
        {
            int sum = num[i] + k % 10 + carry;
            list.add(0, sum % 10);
            carry = sum / 10;
            k = k / 10;
            i--;
        }
        while(i >= 0)
        {
            int sum = num[i] + carry;
            list.add(0, sum % 10);
            carry = sum / 10;
            i--;
        }
        while(k > 0)
        {
            int sum = k % 10 + carry;
            list.add(0, sum % 10);
            carry = sum / 10;
            k = k / 10;
        }
        if(carry != 0)
            list.add(0, carry);
        return list;
    }
}