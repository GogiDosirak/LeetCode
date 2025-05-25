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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }
        DFS(root, 0, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return answer;
    }

    public void DFS(TreeNode node, int sum, int targetSum) {
        if(node == null) {
            return;
        }

        sum += node.val;

        if(targetSum == sum) {
            answer++;
        }

        DFS(node.left, sum, targetSum);
        DFS(node.right, sum, targetSum);

    }
}