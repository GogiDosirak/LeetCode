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
        // LCA - 가장 깊은 공통 조상
        // “조상”에는 자기 자신도 포함
        // 노드의 최대 개수는 10^5 - O(N^2) 불가능
        // 각 노드의 value는 unique
        if(root == null || root == p || root == q) {
            return root;
        }

        // 왼쪽 탐색
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 오른쪽 탐색
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 만약 왼쪽 오른쪽에서 골고루 p,q가 발견됐다면
        // 그 재귀의 root 노드가 LCA
        if(left != null && right != null) {
            return root;
        }

        // 왼쪽에서만 발견됐다면, 왼쪽 재귀의 루트가 LCA
        // 오른쪽에서만 발견됐다면, 오른쪽 재귀의 루트가 LCA
        if(left != null && right == null) {
            return left;
        } else {
            return right;
        }
    }
}