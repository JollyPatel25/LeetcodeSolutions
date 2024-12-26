class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrToBST(nums, 0 , nums.length - 1);
    }
    public TreeNode arrToBST(int nums[], int low, int high)
    {
        if(low > high)
            return null;
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrToBST(nums, low, mid - 1);
        root.right = arrToBST(nums, mid + 1, high);
        return root;
    }
}