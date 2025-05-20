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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int answer = 0;
        if(root == null) {
            return answer;
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            for(int i = 0 ; i < size; i++) {
                TreeNode node = queue.poll();

                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
                levelSum += node.val;
            }
            answer = levelSum;
        }
        return answer;
    }
}