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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        DFS(root, k);
        return answer; 
    }

    public void DFS(TreeNode node, int k) {
        if(node == null) {
            return;
        }

        DFS(node.left, k);
        if(++count == k) { 
            answer = node.val;
            return;
        } 
        DFS(node.right, k);

        return;
    }
}