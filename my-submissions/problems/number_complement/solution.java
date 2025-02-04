class Solution {
    public int findComplement(int num) {
        int temp = num;
        int count = 0;
        while(num != 0 )
        {
            num = num >> 1;
            count++;
        }
        StringBuilder sb  = new StringBuilder();
        for(int i = 0 ; i < count; i++)
        {
            sb.append(1);
        }
        int mask = Integer.parseInt(sb.toString(), 2);
        return (temp ^ mask);
    }
}