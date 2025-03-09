class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int arr[] = new int[2];
        int low = 0, high = numbers.length - 1;
        while(low < high)
        {
            int sum = numbers[low] + numbers[high];
            if(sum == target)
            {
                arr[0] = low + 1;
                arr[1] = high + 1;
                return arr;
            }
            else if(sum < target)
                low++;
            else
                high--;
        }
        return arr;
    }
}