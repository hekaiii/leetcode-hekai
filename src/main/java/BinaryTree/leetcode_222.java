package BinaryTree;

/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/12/11
 */
public class leetcode_222 {
  public static int countNodes(TreeNode root) {
    int result = 0;
    preorder(root);
    return result;
  }

  private static void preorder(TreeNode node) {
    if (node == null) {
      return;
    }

    preorder(node.left);
    preorder(node.right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(4);
    root.left.left.left.left = new TreeNode(4);
    System.out.println(countNodes(root));
  }
}
