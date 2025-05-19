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
    int answer = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        DFS(root, 1);
        return answer;

    }

    public void DFS(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            answer = Math.min(answer, depth);
        }

        DFS(root.left, depth+1);
        DFS(root.right, depth+1);
    }
}