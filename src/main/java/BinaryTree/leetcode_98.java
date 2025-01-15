package BinaryTree;


/**
 * @Author: hekai
 * @Description:
 * @Date: 2024/12/17
 */
public class leetcode_98 {
  public static boolean isValidBST(TreeNode root) {
    return getResult(root,null,null);
  }

  private static boolean getResult(TreeNode node, Integer min, Integer max) {
    if (node == null) {
      return true;
    }
    if ((min != null && node.val < min) || (max != null
        && node.val > max)) {
      return false;
    }
    return getResult(node.left, min, node.val) && getResult(node.right, node.val, max);
  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode(5);
    node.left = new TreeNode(4);
    node.right = new TreeNode(8);
    node.right.left = new TreeNode(6);
    node.right.right = new TreeNode(9);
    System.out.println(isValidBST(node));
  }
}
