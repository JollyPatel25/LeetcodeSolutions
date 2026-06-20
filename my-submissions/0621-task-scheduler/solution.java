class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : tasks) map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        maxHeap.addAll(map.values());

        Queue<int[]> cooldown = new LinkedList<int[]>();
        int time = 0;

        while(!maxHeap.isEmpty() || !cooldown.isEmpty())
        {
            time++;
            if(!maxHeap.isEmpty())
            {
                int count = maxHeap.poll() - 1;
                if(count > 0)
                {
                    cooldown.offer(new int[]{count, time + n});
                }
            }

            if(!cooldown.isEmpty() && cooldown.peek()[1] == time)
            {
                maxHeap.offer(cooldown.poll()[0]);
            }
        }

        return time;
    }
}
