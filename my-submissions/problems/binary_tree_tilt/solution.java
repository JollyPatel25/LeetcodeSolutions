class Solution {
    public int findTilt(TreeNode root) {
        int[] totalTilt = new int[1]; 
        sum(root, totalTilt);
        return totalTilt[0];
    }
    public int sum(TreeNode root, int[] totalTilt) {
        if (root == null) return 0;
        int leftSum = sum(root.left, totalTilt);
        int rightSum = sum(root.right, totalTilt);
        totalTilt[0] += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
