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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // 자식이 없는 경우
            if (root.left == null && root.right == null) {
                return null;
            }
            // 하나의 자식만 있는 경우
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }
            // 두 자식이 모두 있는 경우
            // 오른쪽에서 가장 작은 값 또는 왼쪽에서 가장 큰 값을 root에 넣어야 BST의 특성을 지킬 수 있음
            // 오른쪽에서 가장 작은 값을 찾아보자. -> root 값에 반영 후 삭제
            else {
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }
            return root;
        }

    private TreeNode findMin(TreeNode node) {
        if(node.left == null) {
            return node;
        }
        TreeNode left = findMin(node.left);
        return left;
    }
}