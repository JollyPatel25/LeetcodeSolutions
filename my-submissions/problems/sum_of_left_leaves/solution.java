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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
        {return 0;}
        int sum = 0;
        if(root.left != null)
        {
            sum += isLeftLeaf(root.left);
            sum += sumOfLeftLeaves(root.left);
        }
        if(root.right != null)
        {
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }
    public int isLeftLeaf(TreeNode root)
    {
        if(root.left == null && root.right == null)
            return root.val;
        return 0;
    }
}