class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = head, prev = null;
        while(temp != null)
        {
            if(temp.val == val)
            {
                if(temp == head)
                {
                    head = head.next;
                    temp = head;
                    continue;
                }
                if(temp.next == null)
                {
                    prev.next = null;
                    return head;
                }
                prev.next = temp.next;
                temp = temp.next;
            }
            else
            {
                prev = temp;
                temp = temp.next;
            }
            
        }
        return head;
    }
}