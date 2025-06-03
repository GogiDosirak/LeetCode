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
    List<Integer> list = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        DFS(root1);
        DFS(root2);
        Collections.sort(list);
        return list;
    }

    public void DFS(TreeNode node) {
        if(node == null) {
            return;
        }

        list.add(node.val);
        DFS(node.left);
        DFS(node.right);

        return;
    }
}