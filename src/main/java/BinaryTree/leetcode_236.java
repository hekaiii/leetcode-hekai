package BinaryTree;

import java.net.NoRouteToHostException;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/24
 */
public class leetcode_236 {

  //后 左右中
  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (root == p || root == q) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null || right != null) {
      return root;
    }
    return left != null ? left : right;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);

    root.right = new TreeNode(1);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);
    TreeNode treeNode = lowestCommonAncestor(root, root.left.right, root.left.right.right);
    System.out.println(treeNode.val);

  }
}
