class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int count = 1, countL = 0, countR = 0;
        if(root.left == null && root.right == null)
            return count;
        if(root.left != null)
        {
            countL += minDepth(root.left);
        }
        if(root.right != null)
        {
            countR += minDepth(root.right);
        }
        if(countL < countR)
        {
            if(countL != 0)
            {
                return count + countL;
            }
            else
            {
                return count + countR;
            }
        }
        else {
            if(countR  == 0)
            {
                return count + countL;
            }
        }
        return count + countR;
    }
}