public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode slow = head, fast = head;
        while(slow != null && fast != null)
        {
            slow = slow.next;
            if(fast.next == null)
                return false;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    } 
}