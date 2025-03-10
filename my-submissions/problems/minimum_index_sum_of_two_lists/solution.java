class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int sum[] = new int[list1.length > list2.length ? list1.length : list2.length];
        Arrays.fill(sum, -1);
        for(int i = 0; i < list1.length; i++)
            for(int j = 0; j < list2.length; j++)
                if(compare(list1[i], list2[j]))
                    sum[i] = i + j;
        int min = list1.length + list2.length;
        for(int i = 0 ; i < sum.length; i++)
            if(sum[i] < min && sum[i] >= 0)
                min = sum[i];
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < sum.length; i++)
            if(sum[i] == min)
                list.add(list1[i]);
        return list.toArray(new String[list.size()]);
    }
    public boolean compare(String s1, String s2)
    {
        if(s1.length() != s2.length())
            return false;
        for(int i = 0; i < s1.length(); i++)
            if(s1.charAt(i) != s2.charAt(i))
                return false;
        return true;
    }
    
}