class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int min = -1;
        ListNode list = null, temp = null;
        boolean notOver = true; 
        if(lists.length == 0)
            return null;
        while(notOver){
            min = -1;
            notOver = false;
            for(int k = 0; k < lists.length; k++)
            {
                if(lists[k] != null)
                { 
                    notOver = true;
                    if(min == -1)
                        min = k;
                    if(lists[min] != null)
                        if(lists[k].val <= lists[min].val)
                            min = k;
                }
            }
            if(!notOver)
                break;
            if(min >= 0 && lists[min] != null)
            {
                if(list == null)
                {
                    list = new ListNode(lists[min].val, null);
                    temp = list;
                    lists[min] = lists[min].next;
                }  
                else
                {
                    temp.next = new ListNode(lists[min].val, null);
                    lists[min] = lists[min].next;
                    if(temp.next != null)
                        temp = temp.next;
                }  
            }
        }
        if(temp != null)
            temp.next = null;
        return list;
    }
}