class Solution {
public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int min = -1, max = -1;
        long index = -1;
        
        ListNode temp = head, prev = null;
        ArrayList<Long> al = new ArrayList<Long>();
        while(temp.next != null)
        {
            index++;
            if(temp == head)
            {
                prev = temp;
                temp = temp.next;
                continue;
            }
            if((temp.val < prev.val && temp.val < temp.next.val) || 
            (temp.val > prev.val && temp.val > temp.next.val))
            {
                al.add(Long.valueOf(index));
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println(al);
        if(al.size() >= 2)
        {
            int value;
            max = (int)(al.get(al.size() - 1) - al.get(0));
            min = (int)(al.get(1) - al.get(0)); 
            for(int i = 2; i < al.size(); i++)
            {
                value = (int)(al.get(i) - al.get(i - 1));
                if(min > value){
                    min = value;
                }
            }
        }
        int result[] = {min, max};
        return result;
    }
}