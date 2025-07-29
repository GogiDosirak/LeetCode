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
    public int maxDepth(TreeNode root) {
        DFS(root, 1);
        return answer;
    }

    public void DFS(TreeNode node, int depth) {
        if(node == null) {
            return;
        }

        answer = Math.max(answer,depth);

        DFS(node.left, depth + 1);
        DFS(node.right, depth + 1);
    }

    
}
