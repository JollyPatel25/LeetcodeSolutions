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
    public int countNodes(TreeNode root) {
        return count(root);
    }
    public int count(TreeNode root)
    {
        int sum = 0;
        if(root == null)
            return 0;
        else
            sum++;
        if(root.left != null)
            sum += count(root.left);
        if(root.right != null)
            sum += count(root.right);
        return sum;
    }
}