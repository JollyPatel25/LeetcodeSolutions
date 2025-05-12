class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode one = head, two = head, prev = head; 
        while(two != null && two.next != null)
        {
            prev = one;
            one = one.next;
            two = two.next.next;
        }
        prev.next = null;
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(one);
        return merge(list1, list2);
    }
    private ListNode merge(ListNode head1, ListNode head2)
    {
        ListNode newHead = null, temp = null;
        while(head1 != null && head2 != null)
        {
            if(head1.val < head2.val)
            {
                if(newHead == null)
                {
                    newHead = new ListNode(head1.val);
                    temp = newHead;
                }
                else
                {
                    temp.next = new ListNode(head1.val);
                    temp = temp.next;
                }
                head1 = head1.next;
            }
            else
            {
                if(newHead == null)
                {
                    newHead = new ListNode(head2.val);
                    temp = newHead;
                }
                else
                {
                    temp.next = new ListNode(head2.val);
                    temp = temp.next;
                }
                head2 = head2.next;
            }
        }
        while(head1 != null)
        {
            temp.next = new ListNode(head1.val);
            temp = temp.next;
            head1 = head1.next;
        }
        while(head2 != null)
        {
            temp.next = new ListNode(head2.val);
            temp = temp.next;
            head2 = head2.next;
        }
        return newHead;
    }
}