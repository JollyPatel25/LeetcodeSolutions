class Solution {
    class Data{
        public int height;
        public int diameter;
        Data()
        {
            height = diameter = 0;
        }
        Data(int d, int h)
        {
            diameter = d;
            height = h;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).diameter;
    }
    private Data helper(TreeNode root)
    {
        if(root == null) return new Data(0, 0);
        if(root.left == null && root.right == null)
        {
            return new Data(0, 1);
        }
        Data left = helper(root.left);
        Data right = helper(root.right);
        Data d = new Data();
        d.height = Math.max(root.left != null ? left.height : 0, 
                            root.right != null ? right.height: 0) + 1;
        int dia1 = root.left != null ? left.height : 0; 
        dia1 += root.right != null ? right.height : 0; 
        int dia2 = Math.max(root.left != null ? left.diameter : 0, 
                            root.right != null ? right.diameter: 0);
        d.diameter = Math.max(dia1, dia2);
        return d;
    }
}