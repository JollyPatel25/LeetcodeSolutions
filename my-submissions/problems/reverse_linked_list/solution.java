class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head.next, list = head, temp2 = head;
        list.next = null;
        while(temp != null)
        {
            list = temp;
            temp = temp.next;  
            list.next = head;
            head = list;
        }
        return head;
    }
}