class Solution {
    public int hammingWeight(int n) {
        StringBuilder sb =  new StringBuilder();
        int count = 0;
        while(n > 0)
        {
            if(n % 2 != 0)
                sb.append("1");
            else
                sb.append("0");
            n = n / 2;
        }
        for(int i = 0; i < sb.length(); i++)
        {
            if(sb.charAt(i) == '1')
                count++;
        }
        return count;
    }
}