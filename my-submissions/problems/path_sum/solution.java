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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        return findPath(root, targetSum, 0);
    }
    public boolean findPath(TreeNode root, int targetSum, int sum)
    {
        if(root == null)
            return false;
        if(root.val + sum == targetSum && root.right == null && root.left == null)
            return true;
        return findPath(root.left,targetSum, sum + root.val) || findPath(root.right,targetSum, sum + root.val);
    }
}