class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Arrays.stream(piles).max().getAsInt();

        while(min < max)
        {
            int mid = min + (max - min) / 2;
            int hours = 0;
            for (int i = 0; i < piles.length; i++)
            {
                hours += ((piles[i] + mid - 1) / mid);
            }
            if (hours <= h) max = mid;
            else min = mid + 1;
        }   
        return min;    
    }
}
