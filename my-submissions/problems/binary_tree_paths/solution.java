class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<String>();
        path(root,new StringBuilder(), list);
        return list;
    }
    public void path(TreeNode root, StringBuilder sb1, ArrayList<String> list)
    {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(sb1);
        if(root != null)
        {
            if(sb2.length() > 0)
                sb2.append("->");
            sb2.append(root.val);
            if(root.left == null && root.right == null)
            {
                list.add(sb2.toString());
                sb2.setLength(0);
            }
            if(root.left != null)
                path(root.left, sb2, list);
            if(root.right != null)
                path(root.right, sb2, list);
        }
    }
}