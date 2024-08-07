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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        postorder(root, list);
        return list;
    }
    void postorder(TreeNode root, List<Integer> list)
    {
        if(root.left != null)
            postorder(root.left, list);
        if(root.right != null)
            postorder(root.right, list);
        list.add(root.val);
    }
}