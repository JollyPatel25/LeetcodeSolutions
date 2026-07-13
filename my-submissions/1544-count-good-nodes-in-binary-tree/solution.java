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
    int count = 0;
    public int goodNodes(TreeNode root) {
        findGoodies(root, root.val);
        return count;
    }

    public void findGoodies(TreeNode root, int max)
    {
        if(root == null) return;

        if(max <= root.val) count++;

        int newMax = Math.max(max, root.val);

        findGoodies(root.left, newMax);
        findGoodies(root.right, newMax);
    }
}
