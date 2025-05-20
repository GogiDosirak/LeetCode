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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        if(root == null) {
            return answer;
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int count = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                count++;
                if(node.left != null) {
                    queue.add(node.left);
                }
        
                if(node.right != null) {
                    queue.add(node.right);
                }

                if(count == size) {
                    answer.add(node.val);
                }
            }
        } 
        return answer;
    }
}