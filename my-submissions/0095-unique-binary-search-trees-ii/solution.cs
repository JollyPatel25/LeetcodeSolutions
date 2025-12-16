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
    public IList<TreeNode> GenerateTrees(int n) {
        return Build(1, n);
    }

    private IList<TreeNode> Build(int start, int end) {
        IList<TreeNode> result = new List<TreeNode>();

        if (start > end) {
            result.Add(null);
            return result;
        }

        for (int rootVal = start; rootVal <= end; rootVal++) {
            var leftTrees = Build(start, rootVal - 1);
            var rightTrees = Build(rootVal + 1, end);

            foreach (var left in leftTrees) {
                foreach (var right in rightTrees) {
                    TreeNode root = new TreeNode(rootVal);
                    root.left = left;
                    root.right = right;
                    result.Add(root);
                }
            }
        }

        return result;
    }
}

