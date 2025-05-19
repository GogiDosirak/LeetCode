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
    int target = 0;
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        return DFS(root, 0);
    }

    private boolean DFS(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null) {
            return sum + root.val == target;
        }

        sum += root.val;
        boolean left = DFS(root.left, sum);
        boolean right = DFS(root.right, sum);

        return left || right;
    }
}