class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while(n != 1 && !set.contains(n))
        {
            set.add(n);
            int count = 0;
            int temp = n;
            while(temp > 0)
            {
                int last = temp % 10;
                count += last * last;
                temp = (int)temp / 10;
            }
            n = count;
        }
        return n == 1;
    }
}