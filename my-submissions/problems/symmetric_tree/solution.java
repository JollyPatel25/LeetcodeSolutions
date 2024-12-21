class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root.right == null && root.left == null)
            return true;
        else if(root.left != null && root.right != null)
        {
            if(root.left.val == root.right.val)
                return checkSymmetric(root.left, root.right);
            else
                return false;
        }
        return false;
    }
    public boolean checkSymmetric(TreeNode rootL, TreeNode rootR)
    {
        boolean temp = true;
        if(rootL.val == rootR.val)
        {
            if(rootL.left != null && rootR.right != null)
            {
                temp = temp && (rootL.left.val == rootR.right.val);
                temp = temp && checkSymmetric(rootL.left, rootR.right);
            } 
            else if(rootL.left == null && rootR.right == null){} 
            else 
                return false;
            if(rootL.right != null && rootR.left != null)
            {
                temp = temp && (rootL.right.val == rootR.left.val);
                temp = temp && checkSymmetric(rootL.right, rootR.left);
            }
            else if(rootL.right == null && rootR.left == null){}
            else
                return false;
        }
        else
        {
            return false;
        }
        return temp;
    }
}