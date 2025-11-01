/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode ModifiedList(int[] nums, ListNode head) {
        ListNode temp = head, prev = null;
        HashSet<int> set = new HashSet<int>(nums);
        while(temp != null)
        {
            if(set.Contains(temp.val))
            {
                if(head == temp)
                {
                    head = head.next;
                    temp = head;
                }
                else
                {
                    temp = temp.next;
                    if(prev != null){
                        prev.next = temp;
                    }
                }
            }
            else{
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}