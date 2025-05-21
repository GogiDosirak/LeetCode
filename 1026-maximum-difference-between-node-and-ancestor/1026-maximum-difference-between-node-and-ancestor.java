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
    int answer = 0;
    public int maxAncestorDiff(TreeNode root) {
        DFS(root, root.val, root.val);
        return answer;
    }

    public void DFS(TreeNode node, int max, int min) {
        if(node == null) {
            return;
        }

        max = Math.max(max, node.val);
        min = Math.min(min, node.val);

        answer = Math.max(answer, max - min);

        DFS(node.left, max, min);
        DFS(node.right, max, min);
    }
}