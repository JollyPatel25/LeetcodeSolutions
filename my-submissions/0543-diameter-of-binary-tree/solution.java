class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        findPath(root);
        return max;
    }

    public int findPath(TreeNode root)
    {
        if(root == null) return 0;

        int leftTreeHeight = findPath(root.left);
        int rightTreeHeight = findPath(root.right);

        max =  Math.max(max, leftTreeHeight + rightTreeHeight);

        return 1 + Math.max(leftTreeHeight, rightTreeHeight);
    }
}
