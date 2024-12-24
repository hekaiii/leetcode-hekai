package BinaryTree;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/24
 */
public class leetcode_235 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (root == p || root == q) {
      return root;
    }
    TreeNode left = null;
    TreeNode right = null;
    if (p.val < root.val || q.val < root.val) {
      left = lowestCommonAncestor(root.left, p, q);
    }
    if (p.val > root.val || q.val > root.val) {
      right = lowestCommonAncestor(root.right, p, q);
    }
    if (left != null && right != null) {
      return root;
    }
    return left != null ? left : right;
  }

  public TreeNode lowestCommonAncestor01(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val > root.val && q.val > root.val) {
      return lowestCommonAncestor01(root.right, p, q);
    }
    if (p.val < root.val && q.val < root.val) {
      return lowestCommonAncestor01(root.left, p, q);
    }
    return root;
  }

  public static void main(String[] args) {

  }
}
