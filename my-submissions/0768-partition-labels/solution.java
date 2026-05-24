class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<Integer>();
        int[] lastOccurence = new int[26];
        int n = s.length();
        for (int i = 0 ; i < n; i++)
        {
            lastOccurence[s.charAt(i) - 'a'] = i;
        }
        int i = 0; 
        int end = 0;
        int start = 0;
        while (i < n)
        {
            end = Math.max(end, lastOccurence[s.charAt(i) - 'a']);
            if (i == end) {
                list.add(end - start + 1);
                start = end + 1;
            }
            i++;
        }
        return list;
    }
}
