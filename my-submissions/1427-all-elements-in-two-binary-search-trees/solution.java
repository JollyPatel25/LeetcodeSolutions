/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> one, two;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        TreeNode curr1 = root1;
        TreeNode curr2 = root2;

        while(curr1 != null || curr2 != null || !stack1.isEmpty() || !stack2.isEmpty())
        {
            while(curr1 != null)
            {
                stack1.push(curr1);
                curr1 = curr1.left;
            }
            while(curr2 != null)
            {
                stack2.push(curr2);
                curr2 = curr2.left;
            }

            if(stack2.isEmpty() || (!stack1.isEmpty() && stack2.peek().val >= stack1.peek().val))
            {
                curr1 = stack1.pop();
                result.add(curr1.val);
                curr1 = curr1.right;
            }
            else
            {
                curr2 = stack2.pop();
                result.add(curr2.val);
                curr2 = curr2.right;
            }
        }
        return result;
    }
}
