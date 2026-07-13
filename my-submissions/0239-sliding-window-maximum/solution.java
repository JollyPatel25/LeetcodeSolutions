class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] max = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < k; i++)
        {
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
            {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        max[0] = nums[deque.peekFirst()];

        for (int i = k; i < nums.length; i++)
        {
            int leftIndex = i - k + 1;
            if (deque.peekFirst() < leftIndex) deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
            {
                deque.pollLast();
            }
            deque.offerLast(i);
            max[leftIndex] = nums[deque.peekFirst()];
        }

        return max;
    }
}
