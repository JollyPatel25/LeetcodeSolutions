/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root != null)
            return findDepth(root, 1);
        return 0;
    }

    public int findDepth(TreeNode root, int length)
    {
        if(root == null) return length;
        
        int leftTreeLength = root.left != null ? findDepth(root.left, length + 1) : length;
        int rightTreeLength = root.right != null ? findDepth(root.right, length + 1) : length;

        return leftTreeLength > rightTreeLength ? leftTreeLength : rightTreeLength;
    }
}
