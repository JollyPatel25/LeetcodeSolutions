class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int count = 1, countL = 0, countR = 0;
        if(root.left != null)
            countL += maxDepth(root.left);
        if(root.right != null)
            countR += maxDepth(root.right);
        if(countL > countR)
        {
            return count + countL;
        }
        return count + countR;
    }
}