package BinaryTree;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/12/24
 */
public class leetcode_701 {
  public static TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }else if (val < root.val) {
      root.left = insertIntoBST(root.left, val);
    } else {
      root.right = insertIntoBST(root.right, val);
    }
    return root;
  }

  private static TreeNode getResult(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }else if (val < root.val) {
      root.left = getResult(root.left, val);
    } else {
      root.right = getResult(root.right, val);
    }
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    TreeNode treeNode = insertIntoBST(root, 5);
  }
}
