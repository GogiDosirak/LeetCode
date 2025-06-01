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
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        DFS1(root1);
        DFS2(root2);

        return list1.equals(list2);
    }

    public void DFS1(TreeNode root1) {
        if(root1 == null) return;

        if(root1.left == null && root1.right == null) {
            list1.add(root1.val);
            return;
        } 

        DFS1(root1.left);
        DFS1(root1.right);
        return;
    }

        public void DFS2(TreeNode root2) {
        if(root2 == null) return;

        if(root2.left == null && root2.right == null) {
            list2.add(root2.val);
            return;
        } 

        DFS2(root2.left);
        DFS2(root2.right);
        return;
    }


}