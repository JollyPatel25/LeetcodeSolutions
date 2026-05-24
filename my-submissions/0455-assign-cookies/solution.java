class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int child = g.length;
        int cookies = s.length;
        int count = 0, i = 0, j = 0;
        while(i < child && j < cookies)
        {
            if(s[j] >= g[i]){
                i++; 
                j++;
                count++;
            }
            else {
                j++;
            }
        }
        return count;
    }
}
