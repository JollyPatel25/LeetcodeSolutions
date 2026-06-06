class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        List<Integer> tail = new ArrayList<Integer>();

        for (int[] env : envelopes)
        {
            int h = env[1];
            int low = 0,  high = tail.size();
            while(low < high)
            {
                int mid = low + (high - low) / 2;
                if(h > tail.get(mid)) low = mid + 1;
                else high = mid;
            }
            if(low == tail.size()) tail.add(h);
            else tail.set(low, h);
        }

        return tail.size();
    }
}
