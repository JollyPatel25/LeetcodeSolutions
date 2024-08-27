class Solution {
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb1 = new StringBuilder();
        
        if(head == null)
            return false;
        if(head.next == null)
            return true;
        while(head != null)
        {
            sb1.append(String.valueOf(head.val));
            head = head.next;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(sb1));
        sb1 = sb1.reverse();
        if(sb2.toString().equals(sb1.toString()))
            return true;
        return false;
    }
}