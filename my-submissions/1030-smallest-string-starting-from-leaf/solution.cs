/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public string SmallestFromLeaf(TreeNode root) {
        if(root == null) return "";
        List<StringBuilder> list;
        List<StringBuilder> backtrack(TreeNode node)
        {
            List<StringBuilder> list = new List<StringBuilder>();
            if(node.left == null && node.right == null)
            {
                StringBuilder sb = new StringBuilder();
                sb.Append((char)(97 + node.val));
                list.Add(sb);
                return list;
            }
            if(node.left != null)
                list.AddRange(backtrack(node.left));
            if(node.right != null)
                list.AddRange(backtrack(node.right));
            for(int i = 0; i < list.Count; i++)
            {
                list[i].Append((char)(97 + node.val));
            }
            return list;
        }
        list = backtrack(root);
        string smallest = list[0].ToString();
        foreach (var sb in list)
        {
            string s = sb.ToString();
            if (string.Compare(s, smallest, StringComparison.Ordinal) < 0)
                smallest = s;
        }
        return smallest;
    }
}
