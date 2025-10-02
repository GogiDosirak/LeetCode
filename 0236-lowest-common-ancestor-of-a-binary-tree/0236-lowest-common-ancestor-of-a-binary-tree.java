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
        // 사고과정 - 왼쪽 / 오른쪽 탐색을 해 
        // 왼쪽이나 오른쪽에서 p나 q를 만난다면 아래는 더 이상 탐색할 필요가 없음 -> return
        // 왼쪽이나 오른쪽에만 값이 있다면 둘 다 왼쪽/오른쪽에만 있음 -> left/right 반환
        // 둘 다 있다면 그 둘의 root 노드가 LCA -> root 반환
        if(root == p || root == q) {
            return root;
        }
        
        if(root == null) {
            return null;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }

        if(left != null && right == null) {
            return left;
        } else {
            return right;
        }
    }
}