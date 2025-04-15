class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < index.length; i++)
        {
            list.add(index[i], nums[i]);
        }
        int arr[] = new int[list.size()];
        for(int i = 0 ; i < arr.length; i++)
        {
            arr[i] = list.get(0);
            list.remove(0);
        }
        return arr;
    }
}