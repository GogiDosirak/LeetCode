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
    int depth = 0;
    int max = 0;
    public int maxDepth(TreeNode root) {
        DFS(root);
        return max;
    }

    private void DFS(TreeNode root) {
        if(root == null) {
            return;
        }
        depth++;
        max = Math.max(max, depth);
        DFS(root.left);
        DFS(root.right);
        depth--;
    }
}
