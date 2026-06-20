class Solution {
    public String reorganizeString(String s) {

        HashMap<Character, Integer> freqs = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) freqs.put(c, freqs.getOrDefault(c, 0) + 1);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Character, Integer> entry : freqs.entrySet())
        {
            maxHeap.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        StringBuilder sb = new StringBuilder();
        int[] prev = null;

        while(!maxHeap.isEmpty() || prev != null)
        {
            if(maxHeap.isEmpty()) return "";
            int[] curr = maxHeap.poll();
            sb.append((char)curr[0]);
            curr[1]--;
            if(prev != null)
            {
                maxHeap.offer(prev);
            }
            prev = curr[1] > 0 ? curr : null; 
        }

        return sb.toString();
    }
}
