class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < 2 * nums.length; i++)
        {
            int actualIndex = i % nums.length;
            while(!stack.isEmpty() && nums[stack.peek()] < nums[actualIndex])
            {
                int index = stack.pop();
                result[index] = nums[actualIndex];
            }
            if(i < nums.length) stack.push(actualIndex);
        }

        return result;
    }
}
