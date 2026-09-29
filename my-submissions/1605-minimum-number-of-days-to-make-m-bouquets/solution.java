class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long)m * k > bloomDay.length) return -1;
        int min = 1;
        int max = Arrays.stream(bloomDay).max().getAsInt();
        while (min < max)
        {
            int mid = min + (max - min) / 2;
            int streak = 0;
            int count = 0;
            for (int i = 0; i < bloomDay.length; i++)
            {
                if (bloomDay[i] <= mid) {
                    streak++;
                    if(streak == k) 
                    {
                        streak = 0;
                        count++;
                        if (count == m) break;
                    }
                }
                else
                {
                    streak = 0;
                }
            }
            if (count >= m) max = mid;
            else min = mid + 1;
        }
        return min;
    }
}
