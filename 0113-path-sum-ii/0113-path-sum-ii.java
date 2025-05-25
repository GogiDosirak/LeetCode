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
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        DFS(root, targetSum, 0, new ArrayList<>());
        return answer;
    }

    public void DFS(TreeNode node, int targetSum, int sum, List<Integer> list) {
        if(node == null) {
            return;
        }
        
        list.add(node.val);
        sum += node.val;

        if(node.left == null && node.right == null) {
            if(sum == targetSum) {
              answer.add(new ArrayList<>(list)); // 복제
          }
        }

        DFS(node.left, targetSum, sum, list);
        DFS(node.right, targetSum, sum, list);
        list.remove(list.size() - 1);
    }
}