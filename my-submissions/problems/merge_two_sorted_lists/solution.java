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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
        {
            return null;
        }
        ListNode first = new ListNode();;
        ListNode temp = first;

        while(list1 != null && list2 != null)
        {
            if(list1.val <= list2.val)
            {
                temp.val = list1.val;
                System.out.println("Val1: " + first.val);
                temp.next = new ListNode();
                temp = temp.next;
                list1 = list1.next;
            }
            else if(list2.val < list1.val)
            {
                temp.val = list2.val;
                System.out.println("Val2: " + first.val);
                temp.next = new ListNode();
                temp = temp.next;
                list2 = list2.next;
            }
            
        }
        while(list1 != null)
        {
            if(list1.next == null)
            {
                temp.val = list1.val;
                temp.next = null;
                list1 = list1.next;
            }
            else{
                temp.val = list1.val;
            temp.next = new ListNode();
            temp = temp.next;
            list1 = list1.next;
            }
            
        }
        while(list2 != null)
        {
            if(list2.next == null)
            {
                temp.val = list2.val;
                temp.next = null;
                list2 = list2.next;
            }
            else{
                temp.val = list2.val;
                temp.next = new ListNode();
                temp = temp.next;
                list2 = list2.next;
            }
            
        }
        temp = null;
        return first;
    }
}