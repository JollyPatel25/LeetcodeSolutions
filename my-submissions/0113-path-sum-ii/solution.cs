/**
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
    public IList<IList<int>> PathSum(TreeNode root, int targetSum) {
        IList<IList<int>> result = new List<IList<int>>();
        if(root == null) return result;
        IList<int> current = new List<int>();
        int sum = 0;
        void backtrack(TreeNode node)
        {
            current.Add(node.val);
            sum += node.val;
            if(node.left == null && node.right == null && sum == targetSum)
            {
                result.Add(new List<int>(current));
            }
            if(node.left != null)
                backtrack(node.left);
            if(node.right != null)
                backtrack(node.right);
            sum -= node.val;
            current.RemoveAt(current.Count - 1);
        }
        backtrack(root);
        return result;
    }
}
