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
    List<Integer> sortedValues = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        DFS(root);
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i < sortedValues.size(); i++) {
            answer = Math.min(answer, sortedValues.get(i) - sortedValues.get(i-1));
        }
        return answer;
    }

    public void DFS(TreeNode root) {
        if(root == null) {
            return;
        }

        DFS(root.left);
        sortedValues.add(root.val);
        DFS(root.right);
    }
}