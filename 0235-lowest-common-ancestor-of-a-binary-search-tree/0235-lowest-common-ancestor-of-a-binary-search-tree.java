/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        if(root == null) {
            return null;
        }
        if(root.val >= min && root.val <= max) {
            return root;
        } else if(root.val < min) {
         return lowestCommonAncestor(root.right, p, q);
        }else {
         return lowestCommonAncestor(root.left, p, q);
        } 

    }
}