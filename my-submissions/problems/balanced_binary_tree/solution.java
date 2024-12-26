class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        boolean flag = true;
        int depL = 0, depR = 0;
        if(root.left != null)
        {
            flag = (flag && isBalanced(root.left));
            depL =  maxDepth(root.left);
        }
        else
        {
            depL = 0;
        }
        if(root.right != null)
        {
            flag = (flag && isBalanced(root.right));
            depR = maxDepth(root.right);
        }
        else
        {
            depR = 0;
        }
        switch(depL - depR)
        {
            case 0: case 1: case -1:
                flag = (flag && true);
                break;
            default:
                flag = false;
        }
        return flag;
    }
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