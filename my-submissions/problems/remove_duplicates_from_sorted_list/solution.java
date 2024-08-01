/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode temp1 = head, newHead = new ListNode(head.val, null), temp2;
        temp2 = newHead;
        int element = head.val;
        temp1 = temp1.next;
        while (temp1 != null)
        {
            if(element != temp1.val)
            {
                element = temp1.val;
                ListNode newNode = new ListNode(element, null);
                temp2.next = newNode;
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return newHead;
    }
}