class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1, temp2 = l2, first = null;
        ListNode l3 = null, temp = l3;
        int carry = 0;
        boolean flag = false;
        while(temp1 != null && temp2 != null)
        {
            if(flag == false)
            {
                int value = l1.val + l2.val;
                if((int)(value / 10) > 0){
                    first = new ListNode(value % 10, null);
                    carry = 1;
                }
                else
                {
                    first = new ListNode(value, null);
                }
                l3 = first;
                temp = l3;
                flag = true;
            }
            else
            {
                int value = temp1.val + temp2.val + carry;
                carry = 0;
                if((int)(value / 10) > 0){
                    temp.next = new ListNode(value % 10, null);
                    temp = temp.next;
                    carry = 1;
                }
                else{
                    temp.next = new ListNode(value, null);
                    temp = temp.next;
                } 
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while(temp1 != null)
        {
            int value = temp1.val + carry;
            carry = 0;
            if((int)(value / 10) > 0){
                temp.next = new ListNode(value % 10, null);
                temp = temp.next;
                carry = 1;
            }
            else{
                temp.next = new ListNode(value, null);
                temp = temp.next;
            }
            temp1 = temp1.next;
        }
        while(temp2 != null)
        {
            int value = temp2.val + carry;
            carry = 0;
            if((int)(value / 10) > 0){
                temp.next = new ListNode(value % 10, null);
                temp = temp.next;
                carry = 1;
            }
            else{
                temp.next = new ListNode(value, null);
                temp = temp.next;
            }
            temp2 = temp2.next;
        }
        if(carry == 1){
            ListNode last = new ListNode(1, null);
            temp.next = last;
        }
        return l3;   
    }
}