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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        DFS(root);
        return max;
    }

    public int DFS(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = DFS(node.left);
        int right = DFS(node.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;

    }
}