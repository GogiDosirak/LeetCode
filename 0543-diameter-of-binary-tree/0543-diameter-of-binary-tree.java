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

    // 왼쪽 노드까지의 최대깊이 + 오른쪽 노드까지의 최대깊이 
    public int DFS(TreeNode node) {
    if(node == null) {
        return 0;
    }

    int left = DFS(node.left);
    int right = DFS(node.right);

    max = Math.max(max, left + right); // 지름의 최대길이 계산

    return Math.max(left, right) + 1;
  }
}