class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode list = head, temp2 = head, prev = null;
        int count = 1;
        boolean flag = false;
        while(list != null)
        {
            if(count == n)
            {
                if(flag == false){
                    temp2 = head;
                    flag = true;
                }
                if(list.next == null){
                    if(temp2 == head)
                    {
                        head = head.next;
                        return head;
                    }
                    else
                    {
                        prev.next = temp2.next;
                        temp2 = null;
                        return head;
                    }
                }
            }
            else{
                count++;
            }
            prev = temp2;
            temp2 = temp2.next;
            list = list.next;
        }
        return head;
    }
}