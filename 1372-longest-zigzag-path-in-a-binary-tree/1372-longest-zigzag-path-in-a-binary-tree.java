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
    public int longestZigZag(TreeNode root) {
        DFS(root.left, 1, "left");
        DFS(root.right, 1, "right");
        return max;  
    }

    public void DFS(TreeNode node, int length, String direction) {
        if(node == null) {
            return;
        }

        max = Math.max(max, length);

        if(direction.equals("right")) {
            DFS(node.left, length + 1, "left");
            DFS(node.right, 1, "right");
        } else {
            DFS(node.right, length + 1, "right");
            DFS(node.left, 1, "left");
        }

    }
}