package BinaryTree;

/**
 * @Author: hek32
 * @Description:
 * @Date: 2024/12/17
 */
public class leetcode_530 {

  Integer result = Integer.MAX_VALUE;
  TreeNode pre = null;
  public int getMinimumDifference(TreeNode root) {
    inorder(root);
    return result;
  }

  private void inorder(TreeNode node) {
    if (node == null) {
      return;
    }
    inorder(node.left);
    if (pre != null) {
      result = Math.min(result, Math.abs(node.val - pre.val));
    }
    pre = node;
    inorder(node.right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(1);
  }
}
