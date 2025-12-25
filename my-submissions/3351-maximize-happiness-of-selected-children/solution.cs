public class Solution {
    public long MaximumHappinessSum(int[] happiness, int k) {
        Array.Sort(happiness);
        Array.Reverse(happiness);
        long max = 0;
        for(int i = 0; i < k; i++)
        {
            int current = happiness[i] - (i);
            if(current < 0) break;
            else max += current;
        }
        return max;
    }
}
