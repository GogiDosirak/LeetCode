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
    int count = 0;
    public int goodNodes(TreeNode root) {
        DFS(root, root.val);
        return count;
    }

    public void DFS(TreeNode node, int max) {
        if(node == null) {
            return;
        }

        if(node.val >= max) {
            count++;
        }

        DFS(node.left, Math.max(max, node.val));
        DFS(node.right, Math.max(max, node.val));
    }
}