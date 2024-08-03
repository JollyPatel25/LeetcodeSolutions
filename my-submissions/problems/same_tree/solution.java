class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
        {
            return true;
        }
        if(((p == null) ^ (q == null)) == true)
        {
            return false;
        }
        return inorder(p, q);
    }
    boolean inorder(TreeNode p, TreeNode q)
    {
        // left nodes
        if(((p.left == null) ^ (q.left == null)) == true)
        {
            return false;
        }
        if(p.left != null && q.left != null){
            if(!inorder(p.left, q.left)){
                return false;
            }
        }
        
        // root node
        if(p == null ^ q == null)
        {
            return false;
        }
        if(p.val != q.val){
            return false;
        }

        // right nodes
        if(((p.right == null) ^ (q.right == null)) == true)
        {
            return false;
        }
        if(p.right!= null && q.right != null)
        {
            if(!inorder(p.right, q.right)){
                return false;
            }
        }

        return true; 
    }
}